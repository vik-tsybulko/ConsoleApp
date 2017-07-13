package input;

import logic.Logic;
import org.jnativehook.*;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class KeyListener implements NativeKeyListener, Runnable {
    public void run() {
        GlobalScreen.getInstance().addNativeKeyListener(this);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
            Logic.setInterrupt(true);
        }
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VK_Q) {

                GlobalScreen.unregisterNativeHook();
        }
    }

    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }
}

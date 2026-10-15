
package com.xynis.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class XynisClient implements ClientModInitializer {
    private KeyBinding openMenu;

    @Override
    public void onInitializeClient() {
        openMenu = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                "key.xynis.open",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                KeyBinding.Category.MISC
            )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenu.wasPressed()) {
                client.setScreen(new XynisScreen());
            }
        });
    }

    private static class XynisScreen extends Screen {
        protected XynisScreen() {
            super(Text.literal("Xynis Client"));
        }

        @Override
        public void render(DrawContext context, int mouseX,
                           int mouseY, float delta) {
            renderBackground(context, mouseX, mouseY, delta);

            context.drawCenteredTextWithShadow(
                textRenderer, title,
                width / 2, height / 2 - 20, 0x55FFFF
            );

            context.drawCenteredTextWithShadow(
                textRenderer,
                Text.literal("Xynis Safe Client"),
                width / 2, height / 2, 0xFFFFFF
            );

            super.render(context, mouseX, mouseY, delta);
        }

        @Override
        public boolean shouldPause() {
            return false;
      
        }
    }
}

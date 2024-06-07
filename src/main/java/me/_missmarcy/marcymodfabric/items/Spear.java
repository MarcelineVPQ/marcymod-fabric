package me._missmarcy.marcymodfabric.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//create our own class called "Spear"
public class Spear extends Item {
    public Spear(Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of("This is a spear!"));
        tooltip.add(Text.of("Right click to use."));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        //The world, user, and hand parameters are all passed in automatically by the game.
        //The world is the world that the player is in
        //The user is the player that is using the item
        //The hand is the hand that the player is using to use the item

        //Now, you can do whatever you want.

        //See which hand the player is using
        if (hand == Hand.MAIN_HAND){
            user.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, 1.0f, 1.0f);
            user.sendMessage(Text.of("Wooosh!!!"));
        }else{
            user.playSound(SoundEvents.BLOCK_ROOTS_BREAK, 1.0f, 1.0f);
            user.setHealth(0); //kill the player
            user.sendMessage(Text.of("You speared yourself! Ouch. You died."));
        }

        //Indicate that the item was used successfully
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
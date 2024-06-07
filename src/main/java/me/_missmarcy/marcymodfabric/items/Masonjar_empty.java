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


public class Masonjar_empty extends Item {

    private static final Settings ITEM_SETTINGS = new Settings();

    public Masonjar_empty(Settings settings) {
        super(ITEM_SETTINGS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of("Fill it with Hooch"));

    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Consume the item
        ItemStack itemStack = user.getStackInHand(hand);
        if (!user.isCreative()) {
            itemStack.decrement(1); // Decrease the stack size by 1
        }

        // Send a message to the player on their action-bar(overlay)
        user.sendMessage(Text.of("It's Empty!"), true);
        user.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0f, 1.0f);

        // Add status effects to the player
        //duration 20 ticks is 1 second - 500 ticks 25 seconds
        //user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 500, 1));
        //user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 1));

        // Remove the item from the player's hand
        user.setStackInHand(hand, itemStack.isEmpty() ? ItemStack.EMPTY : itemStack);

        // This will return a success and consume the item
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
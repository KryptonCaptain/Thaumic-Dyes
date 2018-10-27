package thaumicdyes.common.lib.event;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class infoColour {

	public static void addColour(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if (stack.getTagCompound() != null) {
			if (stack.getTagCompound().getCompoundTag("display") != null) {
				list.add(EnumChatFormatting.GRAY + "Colore: "
						+ stack.getTagCompound().getCompoundTag("display").getTag("color").toString());
			}
		}
		else list.add(EnumChatFormatting.GRAY + "Colore: Originale");
	}
}

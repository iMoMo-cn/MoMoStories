package com.gq2529.momostories.events;

import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IDLNBT;
import com.gq2529.momostories.util.NBTStrDef.IDLNBTDef;
import com.gq2529.momostories.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModStarterEvents {
	  @SubscribeEvent
	  public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		  EntityPlayer player = event.player;
		  //MoMoFramework.Log(getPlyrIdlTagSafe(player).toString());
		  int lastStarterVer = IDLNBT.getPlayerIdeallandIntSafe(player, IDLNBTDef.STARTER_KIT_VERSION_TAG);
		  if(lastStarterVer < IDLNBTDef.CUR_STARTER_KIT_VERSION) {
			  for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				  ItemStack itemStack = player.inventory.getStackInSlot(i);
				  //月夜狩猎
				  if (itemStack.getItem() == ModItems.LUCY_THE_AXE)
				  {
				  	itemStack.shrink(1);
				  	player.addItemStackToInventory(new ItemStack(ModItems.LUCY_THE_AXE));
				  }
			  }


//			  IDLNBT.setPlayerIdeallandTagSafe(player, STARTER_KIT_VERSION_TAG, CUR_STARTER_KIT_VERSION);
//
//			  ItemStack scry = new ItemStack(Items.QUARTZ);
//			  player.addItemStackToInventory(scry);
//
//			  if (player instanceof EntityPlayerMP) {
//				  CommonFunctions.SendMsgToPlayerStyled((EntityPlayerMP)player, "idlframework.msg.starter_kit_given", TextFormatting.AQUA);
//			  }
//			  MoMoFramework.Log(String.format("Given starter items to player %s, ver %d", player.getDisplayNameString(), CUR_STARTER_KIT_VERSION));
		  }
	  }
	
}

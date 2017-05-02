package thaumicdyes.common.lib.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;

import java.io.IOException;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import thaumicdyes.common.ThaumicDyes;
import thaumicdyes.common.lib.DamageSourceTX;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;


public class TXServerPacketHandler {

	  
	  private void handleTypeChangePacket(ByteBufInputStream dat, EntityPlayerMP player)
	  {
		  try {
			dat.readByte();
			int dim = dat.readInt();
			World world = DimensionManager.getWorld(dim);
		    int x = dat.readInt();
		    int y = dat.readInt();
		    int z = dat.readInt();
		    int x2 = dat.readInt();
		    int y2 = dat.readInt();
		    int z2 = dat.readInt();
		    int type = dat.readInt();
		    int side = dat.readInt();
	
		  }
		  catch (Exception e) {}
	  }
	  


	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent event) {
		EntityPlayerMP player = ((NetHandlerPlayServer)event.handler).playerEntity;
		ByteBufInputStream bbis = new ByteBufInputStream(event.packet.payload());
		//ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
        //DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        byte packetType;
        int dimension;
        byte packetID;

        System.out.println("check1");
        
        try
        {
            packetID = bbis.readByte();
            dimension = bbis.readInt();
            World world = DimensionManager.getWorld(dimension);
           
            if (packetID == 44) {
            	this.handleTypeChangePacket(bbis,player);
            }
            if (packetID == 2 && world!= null) {
            	int readInt = bbis.readInt();
            	if (world.getEntityByID(readInt) != null) {
            		EntityLivingBase target = (EntityLivingBase) world.getEntityByID(readInt);
	                readInt = bbis.readInt();
	            	if (world.getEntityByID(readInt) != null) {
	            		
	            		System.out.println("check2");
	            		
	            		if (player.inventory.armorItemInSlot(3) != null) {
		            		player.inventory.armorItemInSlot(3).damageItem(1, player);
		            		if (player.inventory.armorItemInSlot(3).getItemDamage() == player.inventory.armorItemInSlot(3).getMaxDamage()) {
		            			player.inventory.armorInventory[3] = null;
	            		}
	            		//player.worldObj.spawnParticle("explode", (double)(target.posX + Math.random()-0.5F), (double)(target.boundingBox.maxY + Math.random()/2), (double)(target.posZ + Math.random()-0.5F), 0.0D, 0.0D, 0.0D);


	            		target.attackEntityFrom(DamageSourceTX.witherPlayerDamage(player), 1);
	            		ByteBuf buf = Unpooled.buffer();
	            		ByteBufOutputStream out = new ByteBufOutputStream(buf);
				        try
				        {
				            out.writeByte(3);
				            out.writeInt(world.provider.dimensionId);
				            out.writeInt(target.getEntityId());
				            out.writeInt(player.getEntityId());
				           
				        }
				        catch (Exception ex)
				        {
				            ex.printStackTrace();
				        }
				        FMLProxyPacket packet = new FMLProxyPacket(buf,"tDyes");
				        ThaumicDyes.channel.sendToAll(packet);
				        out.close();
	            		}
	            	}
            	}
            	
            }
                        
     
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
	}
}

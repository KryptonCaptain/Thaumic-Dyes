package thaumicdyes.common.lib.packet;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import thaumcraft.client.fx.bolt.FXLightningBolt;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;

public class TXClientPacketHandler extends TXServerPacketHandler{
	

	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent event) {
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		ByteBufInputStream bbis = new ByteBufInputStream(event.packet.payload());
		//ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
        //DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        byte packetType;
        int dimension;
        byte packetID;

        try
        {
            packetID = bbis.readByte();
            dimension = bbis.readInt();
            World world = DimensionManager.getWorld(dimension);
           
        	if (packetID == 3 ) {

            	if (world!= null) {
            	int readInt = bbis.readInt();
            	if (world.getEntityByID(readInt) != null) {
            		EntityLivingBase target = (EntityLivingBase) world.getEntityByID(readInt);
	                readInt = bbis.readInt();
	            	if (world.getEntityByID(readInt) != null) {
	            		

	            		if (player.getUniqueID()!= Minecraft.getMinecraft().thePlayer.getUniqueID()) {
	            			
		        			FXLightningBolt bolt = new FXLightningBolt(player.worldObj, player.posX, player.boundingBox.minY + player.height / 2.0F + 0.75D, player.posZ, target.posX, target.boundingBox.maxY - 0.5F, target.posZ, player.worldObj.rand.nextLong(), 6, 0.5F, 5);
		        			bolt.defaultFractal();
		        		    bolt.setType(5);
//		        	        if (player.getUniqueID().equalsIgnoreCase("killajoke")) {
//		        	        	bolt.setType(3);
//		        	        }
		        		    bolt.setWidth(0.0625F);
		        		    bolt.finalizeBolt();
		                	//System.out.println(Minecraft.getMinecraft().thePlayer.username);
	            		}
	            	}
            	}
            }
            }
        	bbis.close();
        }
		catch (Exception e) {
			
		}
	}
	
}

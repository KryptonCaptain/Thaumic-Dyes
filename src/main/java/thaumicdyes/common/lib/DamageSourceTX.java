package thaumicdyes.common.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IChatComponent;

public class DamageSourceTX extends EntityDamageSource {
	
	public DamageSourceTX(String name, Entity source) {
	    super(name, source);
	    this.damageSourceEntity = source;
	    this.setDamageBypassesArmor();
	    this.setMagicDamage();
	    this.setDamageIsAbsolute();
	}
	
	@Override
	public IChatComponent func_151519_b(EntityLivingBase target) {
        String s = "death.attack.witherMask";
        return new ChatComponentTranslation(s, new Object[] {target.func_145748_c_(), this.damageSourceEntity.func_145748_c_() } );
    }
	
	public static DamageSource witherPlayerDamage(EntityPlayer source)
	{
	  return new EntityDamageSource("witherMask", source);
	}
	
	/*
	public static EntityDamageSourceElectric causeElectricDamage(Entity source, Entity transmitter) {
	    return new EntityDamageSourceElectric("electric.entity", transmitter, source);
	}*/

}

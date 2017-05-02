package thaumicdyes.common.lib;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

public class DamageSourceTX extends DamageSource {
	
	public DamageSourceTX(String par1Str) {
		super(par1Str);
	}
	
	public static DamageSource witherPlayerDamage(EntityLivingBase par0EntityLiving)
	{
	  return new EntityDamageSource("witherMask", par0EntityLiving);
	}

}

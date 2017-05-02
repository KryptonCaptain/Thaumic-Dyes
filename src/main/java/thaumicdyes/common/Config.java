package thaumicdyes.common;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static Configuration config;
	
	public static Boolean test1;
	
	public static void initialize(File file) {
	    config = new Configuration(file);
	    
	    
	    config.load();
	    
	    
	    
	    
	    
	    
	    
	    config.save();
	    
	    
	}
	
	
}

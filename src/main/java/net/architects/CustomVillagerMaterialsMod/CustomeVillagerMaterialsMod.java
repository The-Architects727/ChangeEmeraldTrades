package net.architects.CustomVillagerMaterialsMod;

import net.architects.CustomVillagerMaterialsMod.config.ModConfigs;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomeVillagerMaterialsMod implements ModInitializer {
	public static final String MOD_ID = "customvillagermaterialsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();

		LOGGER.info("Hello Fabric world!");
	}
}

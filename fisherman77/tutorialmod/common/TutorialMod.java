
package fisherman77.tutorialmod.common; //The package your mod is in

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import fisherman77.tutorialmod.common.handlers.TutorialModServerPacketHandler;
import fisherman77.tutorialmod.common.handlers.TutorialModClientPacketHandler;
import fisherman77.tutorialmod.common.items.ItemLime;
import fisherman77.zeuscraft.common.mobs.EntityPegasus;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialMod"}, packetHandler = TutorialModClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialMod"}, packetHandler = TutorialModServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="TutorialMod",name="Tutorial Mod",version="Release")

public class TutorialMod {

@Instance("TutorialMod") //The instance, this is very important later on
public static TutorialMod instance = new TutorialMod();

@SidedProxy(clientSide = "fisherman77.tutorialmod.client.TutorialModClientProxy", serverSide = "fisherman77.tutorialmod.common.TutorialModCommonProxy") //Tells Forge the location of your proxies
public static TutorialModCommonProxy proxy;

	//ITEMS
		public static Item Lime;
	
@PreInit
public void PreInit(FMLPreInitializationEvent e){
	
	//ITEMS
		Lime = new ItemLime(5000).setUnlocalizedName("Lime");
	}

@Init
public void InitTutorialMod(FMLInitializationEvent event){ //Your main initialization method
	
	//BLOCKS (METHOD)
		proxy.registerBlocks();
	
	//ITEMS (METHOD)
		proxy.registerItems();
		
	//MOBS
		//Pegasus
			//registerEntity(EntityCowboy.class, "Cowboy",  0x76F4F4, 0xA2A6BC);
			//LanguageRegistry.instance().addStringLocalization("entity.Cowboy.name", "Cowboy");
	
	//MULTIPLAYER ABILITY
		NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

}

	public void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
		int id = EntityRegistry.findGlobalUniqueEntityId();
	
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, bkEggColor, fgEggColor));
	}

}
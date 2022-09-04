package com.gq2529.momostories.item;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItemStoryboards.*;
import com.gq2529.momostories.item.bows.LunaHunting;
import com.gq2529.momostories.item.food.ModFood.MysteriousMeatballs;
import com.gq2529.momostories.item.misc.IdQuartz;
import com.gq2529.momostories.item.tools.ModTool.*;
import com.gq2529.momostories.item.tools.Replica.Replica_1;
import com.gq2529.momostories.item.tools.Replica.Replica_2;
import com.gq2529.momostories.item.tools.Replica.Replica_3;
import com.gq2529.momostories.item.tools.Replica.Replica_4;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();


	private static final Item.ToolMaterial BOUNDLESS_MATERIAL = EnumHelper.addToolMaterial("boundless_material",5,3000,8,6,9);
	private static final Item.ToolMaterial BOUNDLESS_MATERIAL2 = EnumHelper.addToolMaterial("boundless_material", 5, -1, 16.0F, 4, 9);


//...................................................................................................................................................
	public static final Item ID_SANDPAPER = new ItemBase("id_sandpaper").setCreativeTab(ModCreativeTab.TAB_NAME_4);
	public static final Item ID_QUARTZ = new IdQuartz("id_quartz");
	public static final Item ID_SAND = new ItemBase("id_sand").setCreativeTab(ModCreativeTab.TAB_NAME_4);
	public static final Item LUNA_HUNTING = new LunaHunting("luna_hunting");
	public static final Item WHITE_FESTHERS = new WhiteFeathers("white_feathers");
	public static final Item LUCY_THE_AXE = new LucyAxe("lucy_the_axe");
	public static final Item ANCIENT_MIRRORS =new AncientMirrors("ancient_mirrors");
	public static final Item ORDINARY_HAMMER = new OrdinaryHammer("ordinary_hammer", Item.ToolMaterial.DIAMOND);
	public static final Item FAKE_DIAMOND = new ItemBase("fake_diamond").setCreativeTab(ModCreativeTab.TAB_NAME_4);
	public static final Item THE_FRUIT_OF_THE_FLOWING_YEARS  = new TheFruitofTheFlowingYears("the_fruit_of_the_flowing_years");
	public static final Item BLUE_CALIDAN = new BlueCalidan("blue_calidan");
	public static final Item Palaud_the_Holy_Sword = new PalaudtheHolySword("palaud_the_holy_sword");
	public static final Item REPLICA_1 = new Replica_1("replica_1");
	public static final Item REPLICA_2 = new Replica_2("replica_2");
	public static final Item REPLICA_3 = new Replica_3("replica_3");
	public static final Item REPLICA_4 = new Replica_4("replica_4");
	public static final Item MYSTERIOUS_MEATBALLS = new MysteriousMeatballs("mysterious_meatballs");
	public static final Item MOHE_INK = new ItemBase("mohe_ink").setCreativeTab(ModCreativeTab.TAB_NAME_4);
	public static final Item DEVILS_BLOOD_BUCKET = new DevilsBloodBucket("devils_blood_bucket");
	public static final Item STONE_POWDER = new Powder("stone_powder");
	public static final Item IRON_POWDER = new Powder("iron_powder");
	public static final Item GOLD_POWDER = new Powder("gold_powder");
	public static final Item Proof_of_glory_false = new ProofofGloryFalse("proof_of_glory_false");
	public static final Item GUARDIAN = new ProofofGlory("proof_of_glory");
	public static final Item LETTER_TO_KERRY = new LettertoKerry("letter_to_kerry");
	public static final Item DEAR_Karen =new DearKaren("dear_karen");








	//...................................................................................................................................................................
	public static final Item LUNA_CHURCH = new LunaChurch("luna_church");
	public static final Item CHURCH_OF_THE_SUN_GOD = new ChurchoftheSunGod("church_of_the_sun_god");
	public static final Item THE_SUPREME_MAGI_DEEPLAKE = new TheSupremeMagiDeepLake("the_supreme_magi_deep_lake");
    public static final Item FORGOTTEN_ANCIENT_MIRRORS = new ForgottenAncientMirrors("forgotten_ancient_mirrors");
	public static final Item ALCHEMIST_MEDAL = new AlchemistMedal("alchemist_medal");
	public static final Item FRESHMAN = new Freshman("freshman");
	public static final Item CONSCRIPTION_ORDER = new ConscriptionOrder("conscription_order");
	public static final Item REED = new Reed("reed");
	public static final Item WISEREED = new WiseReed("wisereed");
	public static final Item GARLANFAA_REDEMTION = new GarlandRedemption("garland_redemption");
	public static final Item FORT_SLIM = new FortSlim("fort_slim");
	public static final Item LUNA_BLESSING = new LunaBlessing("luna_blessing");
	public static final Item DAYTIME = new DayTime("daytime");
	public static final Item LEYDEN_JAR = new LeydenJar("leyden_jar");
	public static final Item BLOOD_COOLORED_CALIDAN  = new BloodColoredCalidan("blood_colored_calidan");
	public static final Item DEVILS_BLOOD  = new DevilsBlood("devils_blood");
	public static final Item LUCY_THE_AXE_CARD = new LucyAxeCard("lucy_the_axe_card");
	public static final Item SOUL_PUPPETS = new SoulPuppets("soul_puppets");
	public static final TheBookofForgery THE_BOOK_OF_FORGERY  = new TheBookofForgery("the_book_of_forgery");
	public static final Item AI_LING_WISHES =new AiLingWishes("erin");
	public static final Item NIGHT = new Night("night");
	public static final Item THE_ANGERL_PROJECT = new TheAngelProject("the_angel_project");
	public static final Item ABYSS_CLOISTER = new AbyssCloister("abyss_cloister");
	public static final Item OHAM_HEAVY_CAVALRY_REGIMENT = new OhamHeavyCavalryRegiment("oham_heavy_cavalry_regiment");
	public static final Item ADJUDICATOR_BALANCE = new AdjudicatorBalance("adjudicator_balance");
	public static final Item PLAGUE_DOCTOR =new PlagueDoctor("plague_doctor");
	public static final Item FRAUDULENT_BOTTLES = new FraudulentBottles("fraudulent_bottles");
	public static final Item THE_FRUIT_OF_THE_FLOWING_YEARS_CARD = new TheFruitofTheFlowingYearsCard("the_fruit_of_the_flowing_years_card");
	public static final Item SCAVENGERS =new Scavengers("scavengers");
	public static final Item TWIST = new Twist("twist");
	public static final Item FINE = new Fine("fine");
	public static final Item DARK_CLOUDS = new DarkClouds("dark_clouds");
	public static final Item ESTES = new Estes("estes");
	public static final Item THE_BOOK_OF_MANIFESTATION  = new TheBookofManifestation("the_book_of_manifestation");
	public static final Item BLEEDING = new Bleeding("bleeding");




}

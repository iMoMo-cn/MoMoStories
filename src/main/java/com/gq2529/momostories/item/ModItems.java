package com.gq2529.momostories.item;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItemStoryboards.*;
import com.gq2529.momostories.item.bows.LunaHunting;
import com.gq2529.momostories.item.food.ModFood.MysteriousMeatballs;
import com.gq2529.momostories.item.shields.IdQuartz;
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
	private static final Item.ToolMaterial BOUNDLESS_MATERIA = EnumHelper.addToolMaterial("boundless_material", 5, -1, 16.0F, 4, 9);


//...................................................................................................................................................
	//伊德砂纸
	public static final Item Id_SANDPAPER = new ItemBase("id_sandpaper").setCreativeTab(ModCreativeTab.TAB_NAME_4);
	//伊德石英
	public static final Item Id_QUARTZ = new IdQuartz("id_quartz");
	//伊德砂
	public static final Item Id_SAND = new ItemBase("id_sand").setCreativeTab(ModCreativeTab.TAB_NAME_4);
	//月神狩猎
	public static final Item LUNA_HUNTING = new LunaHunting("luna_hunting");
	//洁白之羽
	public static final Item WHITE_FESTHERS = new WhiteFeathers("white_feathers");
	//露西斧
	public static final Item LUCY_THE_AXE = new LucyAxe("lucy_the_axe");
	//古镜
	public static final Item ANCIENT_MIRRORS =new AncientMirrors("ancient_mirrors");
	//普通的锤子
	public static final Item ORDINARY_HAMMER = new OrdinaryHammer("ordinary_hammer", Item.ToolMaterial.DIAMOND);
	//假钻石
	public static final Item FAKE_DIAMOND = new ItemBase("fake_diamond").setCreativeTab(ModCreativeTab.TAB_NAME_4);
	//岁月之果
	public static final Item THE_FRUIT_OF_THE_FLOWING_YEARS  = new TheFruitofTheFlowingYears("the_fruit_of_the_flowing_years");
	//蓝色卡利丹
	public static  final Item BLUE_CALIDAN = new BlueCalidan("blue_calidan");
	//帕劳德圣剑
	public static final Item Palaud_the_Holy_Sword = new PalaudtheHolySword("palaud_the_holy_sword");
	//复制品1
	public static final Item REPLICA_1 = new Replica_1("replica_1");
	//复制品2
	public static  final Item  REPLICA_2 = new Replica_2("replica_2");
	//复制品3
	public static  final Item  REPLICA_3 = new Replica_3("replica_3");
	//复制品4
	public static  final Item  REPLICA_4 = new Replica_4("replica_4");
	//神秘肉丸
	public static final Item MYSTERIOUS_MEATBALLS = new MysteriousMeatballs("mysterious_meatballs");
	//谟赫墨水
	public static final Item MOHE_INK = new ItemBase("mohe_ink").setCreativeTab(ModCreativeTab.TAB_NAME_4);
	//魔鬼血液桶
	public static final Item DEVILS_BLOOD_BUCKET = new DevilsBloodBucket("devils_blood_bucket");
	//石粉末
	public static final Item STONE_POWDER = new Powder("stone_powder");
	//铁粉末
	public static final Item IRON_POWDER = new Powder("iron_powder");
	//金粉末
	public static final Item GOLD_POWDER = new Powder("gold_powder");
	//盾牌
	public static final Item Proof_of_glory_false = new ProofofGloryFalse("proof_of_glory_false");
	public static final Item GUARDIAN = new ProofofGlory("proof_of_glory");
	//寄往坎瑞的信件
	public static final Item LETTER_TO_KERRY = new LettertoKerry("letter_to_kerry");
	//亲爱的卡莲..
	public static final Item DEAR_Karen =new DearKaren("dear_karen");








	//...................................................................................................................................................................
    //月神教会
	public static final Item LUNA_CHURCH = new LunaChurch("luna_church");
	//太阳神教会
	public static final Item CHURCH_OF_THE_SUN_GOD = new ChurchoftheSunGod("church_of_the_sun_god");
	//至尊魔导师深湖
	public static final Item THE_SUPREME_MAGI_DEEPLAKE = new TheSupremeMagiDeepLake("the_supreme_magi_deep_lake");
	//被遗忘的古镜
    public static final Item FORGOTTEN_ANCIENT_MIRRORS = new ForgottenAncientMirrors("forgotten_ancient_mirrors");
    //炼金术士徽章
	public static final Item ALCHEMIST_MEDALl = new AlchemistMedal("alchemist_medal");
	//新生
	public static final Item FRESHMAN = new Freshman("freshman");
	//强制征兵令
	public static final Item CONSCRIPTION_ORDER = new ConscriptionOrder("conscription_order");
	//苇
	public static final Item REED = new Reed("reed");
	public static final Item WISEREED = new WiseReed("wisereed");
    //加兰德的救赎
	public static final Item GARLANFAA_REDEMTION = new GarlandRedemption("garland_redemption");
	//斯利姆堡
	public static final Item FORT_SLIM = new FortSlim("fort_slim");
	//月神祝福
	public static final Item LUNA_BLESSING = new LunaBlessing("luna_blessing");
	//白日
	public static final Item DAYTIME = new DayTime("daytime");
	//莱顿瓶
	public static final Item LEYDEN_JAR = new LeydenJar("leyden_jar");
	//血色卡利丹
	public static final Item BLOOD_COOLORED_CALIDAN  = new BloodColoredCalidan("blood_colored_calidan");
	//魔鬼血液
	public static final Item DEVILS_BLOOD  = new DevilsBlood("devils_blood");
	//露西斧卡
	public static final Item LUCY_THE_AXE_CARD = new LucyAxeCard("lucy_the_axe_card");
	//灵魂木偶
	public static final Item SOUL_PUPPETS = new SoulPuppets("soul_puppets");
	//赝造之书
	public static final TheBookofForgery THE_BOOK_OF_FORGERY  = new TheBookofForgery("the_book_of_forgery");
	//艾琳的祝愿
	public static final Item AI_LING_WISHES =new AiLingWishes("erin");
	//黑夜
	public static final Item NIGHT = new Night("night");
	//天使计划
	public static final Item THE_ANGERL_PROJECT = new TheAngelProject("the_angel_project");
	//深渊回廊
	public static final Item ABYSS_CLOISTER = new AbyssCloister("abyss_cloister");
	//奥哈姆重骑兵团
	public static final Item OHAM_HEAVY_CAVALRY_REGIMENT = new OhamHeavyCavalryRegiment("oham_heavy_cavalry_regiment");
	//裁决者天平
	public static final Item ADJUDICATOR_BALANCE = new AdjudicatorBalance("adjudicator_balance");
	//瘟疫医生
	public static final Item PLAGUE_DOCTOR =new PlagueDoctor("plague_doctor");
	//欺诈之瓶
	public static final Item FRAUDULENT_BOTTLES = new FraudulentBottles("fraudulent_bottles");
    //岁月之果卡
	public static final Item THE_FRUIT_OF_THE_FLOWING_YEARS_CARD = new TheFruitofTheFlowingYearsCard("the_fruit_of_the_flowing_years_card");
	//食腐者
	public static final Item SCAVENGERS =new Scavengers("scavengers");
	//扭曲
	public static final Item TWIST = new Twist("twist");
	//晴天
	public static final Item FINE = new Fine("fine");
	//雨天
	public static final Item DARK_CLOUDS = new DarkClouds("dark_clouds");
	//艾斯德斯
	public static final Item ESTES = new Estes("estes");
	//具显之书
	public static final Item THE_BOOK_OF_MANIFESTATION  = new TheBookofManifestation("the_book_of_manifestation");
	//流血术
	public static final Item BLEEDING = new Bleeding("bleeding");




}

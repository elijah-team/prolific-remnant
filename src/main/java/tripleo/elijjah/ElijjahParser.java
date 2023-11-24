// $ANTLR 2.7.7 (20060906): "elijjah.g" -> "ElijjahParser.java"$

package tripleo.elijjah;

import antlr.*;
import antlr.collections.impl.BitSet;
import tripleo.elijah.*;
import tripleo.elijah.contexts.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang2.*;

import java.util.*;

public class ElijjahParser extends antlr.LLkParser implements ElijjahTokenTypes {

	public static final String[] _tokenNames = {
	  "<0>",
	  "EOF",
	  "<2>",
	  "NULL_TREE_LOOKAHEAD",
	  "\"as\"",
	  "\"cast_to\"",
	  "\"package\"",
	  "\"indexing\"",
	  "IDENT",
	  "TOK_COLON",
	  "STRING_LITERAL",
	  "CHAR_LITERAL",
	  "NUM_INT",
	  "NUM_FLOAT",
	  "DOT",
	  "\"class\"",
	  "\"struct\"",
	  "\"signature\"",
	  "\"abstract\"",
	  "LBRACK",
	  "RBRACK",
	  "LPAREN",
	  "RPAREN",
	  "LCURLY",
	  "RCURLY",
	  "\"interface\"",
	  "\"type\"",
	  "BECOMES",
	  "BOR",
	  "ANNOT",
	  "\"namespace\"",
	  "\"from\"",
	  "\"import\"",
	  "COMMA",
	  "LT_",
	  "\"constructor\"",
	  "\"ctor\"",
	  "\"destructor\"",
	  "\"dtor\"",
	  "\"continue\"",
	  "\"break\"",
	  "\"return\"",
	  "\"with\"",
	  "\"pre\"",
	  "\"post\"",
	  "\"const\"",
	  "\"immutable\"",
	  "TOK_ARROW",
	  "\"var\"",
	  "\"val\"",
	  "\"alias\"",
	  "\"yield\"",
	  "\"construct\"",
	  "SEMI",
	  "\"invariant\"",
	  "\"access\"",
	  "EQUAL",
	  "PLUS_ASSIGN",
	  "MINUS_ASSIGN",
	  "STAR_ASSIGN",
	  "DIV_ASSIGN",
	  "MOD_ASSIGN",
	  "SR_ASSIGN",
	  "BSR_ASSIGN",
	  "SL_ASSIGN",
	  "BAND_ASSIGN",
	  "BXOR_ASSIGN",
	  "BOR_ASSIGN",
	  "LOR",
	  "LAND",
	  "BXOR",
	  "BAND",
	  "NOT_EQUAL",
	  "GT",
	  "LE",
	  "GE",
	  "\"is_a\"",
	  "SL",
	  "SR",
	  "BSR",
	  "PLUS",
	  "MINUS",
	  "STAR",
	  "DIV",
	  "MOD",
	  "INC",
	  "DEC",
	  "BNOT",
	  "LNOT",
	  "\"true\"",
	  "\"false\"",
	  "\"this\"",
	  "\"null\"",
	  "\"function\"",
	  "\"procedure\"",
	  "\"if\"",
	  "\"else\"",
	  "\"elseif\"",
	  "\"match\"",
	  "\"case\"",
	  "\"while\"",
	  "\"do\"",
	  "\"iterate\"",
	  "\"to\"",
	  "\"generic\"",
	  "QUESTION",
	  "\"typeof\"",
	  "\"func\"",
	  "\"proc\"",
	  "\"in\"",
	  "\"out\"",
	  "\"ref\"",
	  "\"def\"",
	  "\"prop\"",
	  "\"property\"",
	  "\"get\"",
	  "\"set\"",
	  "WS",
	  "SL_COMMENT",
	  "ML_COMMENT",
	  "ESC",
	  "HEX_DIGIT",
	  "VOCAB",
	  "EXPONENT",
	  "FLOAT_SUFFIX"
	};
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());
	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());
	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());
	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());
	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());
	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());
	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());
	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());
	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());
	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());
	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());
	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());
	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());
	public static final BitSet _tokenSet_72 = new BitSet(mk_tokenSet_72());
	public static final BitSet _tokenSet_73 = new BitSet(mk_tokenSet_73());
	public static final BitSet _tokenSet_74 = new BitSet(mk_tokenSet_74());
	public static final BitSet _tokenSet_75 = new BitSet(mk_tokenSet_75());
	public static final BitSet _tokenSet_76 = new BitSet(mk_tokenSet_76());
	public static final BitSet _tokenSet_77 = new BitSet(mk_tokenSet_77());
	public static final BitSet _tokenSet_78 = new BitSet(mk_tokenSet_78());
	public static final BitSet _tokenSet_79 = new BitSet(mk_tokenSet_79());
	public static final BitSet _tokenSet_80 = new BitSet(mk_tokenSet_80());
	public static final BitSet _tokenSet_81 = new BitSet(mk_tokenSet_81());
	public static final BitSet _tokenSet_82 = new BitSet(mk_tokenSet_82());
	public static final BitSet _tokenSet_83 = new BitSet(mk_tokenSet_83());
	public static final BitSet _tokenSet_84 = new BitSet(mk_tokenSet_84());
	public static final BitSet _tokenSet_85 = new BitSet(mk_tokenSet_85());
	public static final BitSet _tokenSet_86 = new BitSet(mk_tokenSet_86());
	public static final BitSet _tokenSet_87 = new BitSet(mk_tokenSet_87());
	public static final BitSet _tokenSet_88 = new BitSet(mk_tokenSet_88());
	public static final BitSet _tokenSet_89 = new BitSet(mk_tokenSet_89());
	public static final BitSet _tokenSet_90 = new BitSet(mk_tokenSet_90());
	public static final BitSet _tokenSet_91 = new BitSet(mk_tokenSet_91());
	public static final BitSet _tokenSet_92 = new BitSet(mk_tokenSet_92());
	public static final BitSet _tokenSet_93 = new BitSet(mk_tokenSet_93());
	public static final BitSet _tokenSet_94 = new BitSet(mk_tokenSet_94());
	public static final BitSet _tokenSet_95 = new BitSet(mk_tokenSet_95());
	public static final BitSet _tokenSet_96 = new BitSet(mk_tokenSet_96());
	public static final BitSet _tokenSet_97 = new BitSet(mk_tokenSet_97());
	public static final BitSet _tokenSet_98 = new BitSet(mk_tokenSet_98());
	public static final BitSet _tokenSet_99 = new BitSet(mk_tokenSet_99());
	public static final BitSet _tokenSet_100 = new BitSet(mk_tokenSet_100());
	public Out out;
	Qualident xy;
	IExpression expr;
	Context     cur;
	Scope3      sco;

	public ElijjahParser(final TokenBuffer tokenBuf) {
		this(tokenBuf, 2);
	}

	protected ElijjahParser(final TokenBuffer tokenBuf, final int k) {
		super(tokenBuf, k);
		tokenNames = _tokenNames;
	}

	public ElijjahParser(final TokenStream lexer) {
		this(lexer, 2);
	}

	protected ElijjahParser(final TokenStream lexer, final int k) {
		super(lexer, k);
		tokenNames = _tokenNames;
	}

	public ElijjahParser(final ParserSharedInputState state) {
		super(state, 2);
		tokenNames = _tokenNames;
	}

	private static final long[] mk_tokenSet_0() {
		final long[] data = {2L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_1() {
		final long[] data = {1125907959939138L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_2() {
		final long[] data = {-219902359568526L, 1973610486956031L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_3() {
		final long[] data = {71837665500642626L, 1970861705986048L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_4() {
		final long[] data = {-8796093022350L, 8726823789658111L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_5() {
		final long[] data = {65056427525308738L, 1970324836974592L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_6() {
		final long[] data = {1125907965182274L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_7() {
		final long[] data = {-219902359568526L, 1971411463700479L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_8() {
		final long[] data = {-8796127035534L, 1973610486956031L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_9() {
		final long[] data = {459008L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_10() {
		final long[] data = {17190879232L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_11() {
		final long[] data = {71820073314598210L, 1970861705986048L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_12() {
		final long[] data = {22020096L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_13() {
		final long[] data = {12582912L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_14() {
		final long[] data = {8388608L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_15() {
		final long[] data = {105553118363904L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_16() {
		final long[] data = {1125907959939072L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_17() {
		final long[] data = {42402048L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_18() {
		final long[] data = {16777216L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_19() {
		final long[] data = {11025664L, 2145583104L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_20() {
		final long[] data = {-72057576427586256L, 2147483647L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_21() {
		final long[] data = {71837665500642560L, 1689386729275392L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_22() {
		final long[] data = {1610645760L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_23() {
		final long[] data = {65056427567710464L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_24() {
		final long[] data = {56048712874492160L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_25() {
		final long[] data = {71908034278833408L, 1689386729275392L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_26() {
		final long[] data = {65055912171634944L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_27() {
		final long[] data = {65055912171634944L, 1688849860263936L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_28() {
		final long[] data = {62839262339185920L, 1970861705986048L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_29() {
		final long[] data = {56049228270567680L, 1970324836974592L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_30() {
		final long[] data = {65056427525308672L, 1970324836974592L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_31() {
		final long[] data = {71820073314598144L, 1970861705986048L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_32() {
		final long[] data = {56049228270567680L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_33() {
		final long[] data = {65056427525308672L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_34() {
		final long[] data = {34013440L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_35() {
		final long[] data = {65056427525308672L, 1688849860263936L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_36() {
		final long[] data = {56048712874492160L, 1688849860263936L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_37() {
		final long[] data = {56048712874493184L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_38() {
		final long[] data = {38034314348232960L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_39() {
		final long[] data = {65056436115259714L, 1970324836974592L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_40() {
		final long[] data = {65056436115243330L, 1970324836974592L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_41() {
		final long[] data = {71908034278833474L, 1970861705986048L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_42() {
		final long[] data = {65056436115259648L, 1688849860263936L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_43() {
		final long[] data = {65056436115243264L, 1688849860263936L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_44() {
		final long[] data = {8602517504L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_45() {
		final long[] data = {56189450773889792L, 1688849860263936L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_46() {
		final long[] data = {7643255091543296L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_47() {
		final long[] data = {-55407122092327632L, 536870911999L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_48() {
		final long[] data = {16650454363061504L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_49() {
		final long[] data = {-79164837200014L, 8726823789658111L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_50() {
		final long[] data = {7635008754302208L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_51() {
		final long[] data = {-55407119944843984L, 1086626725887L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_52() {
		final long[] data = {7643255108320512L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_53() {
		final long[] data = {-79164871213198L, 8726823789658111L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_54() {
		final long[] data = {7643255628414208L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_55() {
		final long[] data = {-55407121555456720L, 536870911999L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_56() {
		final long[] data = {16650454899932416L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_57() {
		final long[] data = {-237503106777808L, 1086626725887L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_58() {
		final long[] data = {-55407119407973072L, 1086626725887L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_59() {
		final long[] data = {7643255645191424L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_60() {
		final long[] data = {-219910920733392L, 6756498952683519L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_61() {
		final long[] data = {71837665500642560L, 6755949194969088L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_62() {
		final long[] data = {16668047085976832L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_63() {
		final long[] data = {8598323200L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_64() {
		final long[] data = {71837674090577664L, 1689386729275392L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_65() {
		final long[] data = {7638857045032192L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_66() {
		final long[] data = {-55411520138838736L, 536870911999L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_67() {
		final long[] data = {16646056316550400L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_68() {
		final long[] data = {-241901153288912L, 1971411463700479L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_69() {
		final long[] data = {-55411517991355088L, 1086626725887L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_70() {
		final long[] data = {7637208314461440L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_71() {
		final long[] data = {-55395574535881424L, 1086626725887L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_72() {
		final long[] data = {-55395576683365072L, 536870911999L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_73() {
		final long[] data = {7654800517545216L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_74() {
		final long[] data = {16661999772024064L, 536869011456L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_75() {
		final long[] data = {-225958234686160L, 1689936486989823L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_76() {
		final long[] data = {27802880L, 2145583104L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_77() {
		final long[] data = {-7001148919054544L, 1688852007747583L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_78() {
		final long[] data = {71820081904533248L, 1970861705986048L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_79() {
		final long[] data = {4194304L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_80() {
		final long[] data = {-144115187941638144L, 15L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_81() {
		final long[] data = {-8796093022350L, 9007199254740991L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_82() {
		final long[] data = {11025664L, 4293066752L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_83() {
		final long[] data = {-72057576444363472L, 2147483647L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_84() {
		final long[] data = {15219968L, 2145583104L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_85() {
		final long[] data = {-219910920733392L, 8445348812947455L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_86() {
		final long[] data = {17179869184L, 3584L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_87() {
		final long[] data = {35184372089088L, 280377075695616L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_88() {
		final long[] data = {-55415366282052304L, 1086626725887L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_89() {
		final long[] data = {-64422567684276944L, 536870911999L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_90() {
		final long[] data = {16650454363061504L, 549753913344L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_91() {
		final long[] data = {16668047085976832L, 549753913344L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_92() {
		final long[] data = {-142L, 9007199254740991L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_93() {
		final long[] data = {256L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_94() {
		final long[] data = {35192968855808L, 142936511610880L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_95() {
		final long[] data = {35184376283392L, 246290604621824L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_96() {
		final long[] data = {-79164871213198L, 2112148952055807L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_97() {
		final long[] data = {-219902359568526L, 2112148952055807L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_98() {
		final long[] data = {35184372089088L, 246290604621824L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_99() {
		final long[] data = {35192966218496L, 140737488355328L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_100() {
		final long[] data = {8594128896L, 0L};
		return data;
	}

	public final void program() throws RecognitionException, TokenStreamException {

		final ParserClosure pc   = out.closure();
		final ModuleContext mctx = new ModuleContext(out.module());
		out.module().setContext(mctx);
		cur = mctx;
		IndexingStatement idx = null;
		OS_Package        pkg;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_indexing: {
					if (inputState.guessing == 0) {
						idx = pc.indexingStatement();
					}
					indexingStatement(idx);
					if (inputState.guessing == 0) {
						pc.module.addIndexingStatement(idx);
					}
					break;
				}
				case EOF:
				case LITERAL_package:
				case LITERAL_class:
				case ANNOT:
				case LITERAL_namespace:
				case LITERAL_from:
				case LITERAL_import:
				case LITERAL_alias: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
_loop4:
				do {
					switch (LA(1)) {
					case LITERAL_package: {
						match(LITERAL_package);
						xy = qualident();
						opt_semi();
						if (inputState.guessing == 0) {
							pkg = pc.defaultPackageName(xy);
							cur = new PackageContext(cur, pkg);
							pkg.setContext((PackageContext) cur);
						}
						break;
					}
					case LITERAL_class:
					case ANNOT:
					case LITERAL_namespace:
					case LITERAL_from:
					case LITERAL_import:
					case LITERAL_alias: {
						programStatement(pc, out.module());
						opt_semi();
						break;
					}
					default: {
						break _loop4;
					}
					}
				} while (true);
			}
			match(Token.EOF_TYPE);
			if (inputState.guessing == 0) {
				out.module().postConstruct();
				out.FinishModule();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_0);
			} else {
				throw ex;
			}
		}
	}

	public final void indexingStatement(
	  final IndexingStatement idx
	) throws RecognitionException, TokenStreamException {

		Token          i1 = null;
		ExpressionList el = null;

		try {      // for error handling
			match(LITERAL_indexing);
			{
				do {
					if ((LA(1) == IDENT)) {
						i1 = LT(1);
						match(IDENT);
						if (inputState.guessing == 0) {
							idx.setName(i1);
						}
						match(TOK_COLON);
						el = expressionList();
						if (inputState.guessing == 0) {
							idx.setExprs(el);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_1);
			} else {
				throw ex;
			}
		}
	}

	public final Qualident qualident() throws RecognitionException, TokenStreamException {
		final Qualident q;

		Token d1 = null;
		q = new Qualident();
		IdentExpression r1 = null, r2 = null;

		try {      // for error handling
			r1 = ident();
			if (inputState.guessing == 0) {
				q.append(r1);
			}
			{
				do {
					if ((LA(1) == DOT) && (LA(2) == IDENT)) {
						d1 = LT(1);
						match(DOT);
						r2 = ident();
						if (inputState.guessing == 0) {
							q.appendDot(d1);
							q.append(r2);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_2);
			} else {
				throw ex;
			}
		}
		return q;
	}

	public final void opt_semi() throws RecognitionException, TokenStreamException {


		try {      // for error handling
			{
				if ((LA(1) == SEMI) && (_tokenSet_3.member(LA(2)))) {
					match(SEMI);
				} else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_3);
			} else {
				throw ex;
			}
		}
	}

	public final void programStatement(
	  final ProgramClosure pc, final OS_Element cont
	) throws RecognitionException, TokenStreamException {

		ImportStatement              imp = null;
		AnnotationClause             a   = null;
		final List<AnnotationClause> as  = new ArrayList<AnnotationClause>();
		AliasStatement               als = null;

		try {      // for error handling
			switch (LA(1)) {
			case LITERAL_from:
			case LITERAL_import: {
				imp = importStatement(cont);
				break;
			}
			case LITERAL_class:
			case ANNOT:
			case LITERAL_namespace: {
				{
					do {
						if ((LA(1) == ANNOT)) {
							a = annotation_clause();
							if (inputState.guessing == 0) {
								as.add(a);
							}
						} else {
							break;
						}

					} while (true);
				}
				{
					switch (LA(1)) {
					case LITERAL_namespace: {
						namespaceStatement__(new NamespaceStatement(cont, cur), as);
						break;
					}
					case LITERAL_class: {
						classStatement(cont, cur, as);
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			case LITERAL_alias: {
				als = aliasStatement(cont);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_5);
			} else {
				throw ex;
			}
		}
	}

	public final ExpressionList expressionList() throws RecognitionException, TokenStreamException {
		final ExpressionList el;

		el = new ExpressionList();

		try {      // for error handling
			expr = expression();
			if (inputState.guessing == 0) {
				el.next(expr);
			}
			{
				do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						expr = expression();
						if (inputState.guessing == 0) {
							el.next(expr);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_6);
			} else {
				throw ex;
			}
		}
		return el;
	}

	public final IExpression constantValue() throws RecognitionException, TokenStreamException {
		IExpression e;

		Token s = null;
		Token c = null;
		Token n = null;
		Token f = null;
		e = null;

		try {      // for error handling
			switch (LA(1)) {
			case STRING_LITERAL: {
				s = LT(1);
				match(STRING_LITERAL);
				if (inputState.guessing == 0) {
					e = new StringExpression(s);
				}
				break;
			}
			case CHAR_LITERAL: {
				c = LT(1);
				match(CHAR_LITERAL);
				if (inputState.guessing == 0) {
					e = new CharLitExpression(c);
				}
				break;
			}
			case NUM_INT: {
				n = LT(1);
				match(NUM_INT);
				if (inputState.guessing == 0) {
					e = new NumericExpression(n);
				}
				break;
			}
			case NUM_FLOAT: {
				f = LT(1);
				match(NUM_FLOAT);
				if (inputState.guessing == 0) {
					e = new FloatExpression(f);
				}
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return e;
	}

	public final IdentExpression ident() throws RecognitionException, TokenStreamException {
		IdentExpression id;

		Token r1 = null;
		id = null;

		try {      // for error handling
			r1 = LT(1);
			match(IDENT);
			if (inputState.guessing == 0) {
				id = new IdentExpression(r1, cur);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_8);
			} else {
				throw ex;
			}
		}
		return id;
	}

	public final ClassStatement classStatement(
	  final OS_Element parent, final Context cctx, final List<AnnotationClause> as
	) throws RecognitionException, TokenStreamException {
		ClassStatement cls;

		cls = null;
		ClassContext    ctx = null;
		IdentExpression i1  = null;
		ClassBuilder    cb  = null;
		TypeNameList    tnl = null;

		try {      // for error handling
			{
				if ((LA(1) == LITERAL_class) && (_tokenSet_9.member(LA(2)))) {
					match(LITERAL_class);
					if (inputState.guessing == 0) {
						cls = new ClassStatement(parent, cctx);
						cls.addAnnotations(as);
					}
					{
						switch (LA(1)) {
						case LITERAL_struct: {
							match(LITERAL_struct);
							if (inputState.guessing == 0) {
								cls.setType(ClassTypes.STRUCTURE);
							}
							break;
						}
						case LITERAL_signature: {
							match(LITERAL_signature);
							if (inputState.guessing == 0) {
								cls.setType(ClassTypes.SIGNATURE);
							}
							break;
						}
						case LITERAL_abstract: {
							match(LITERAL_abstract);
							if (inputState.guessing == 0) {
								cls.setType(ClassTypes.ABSTRACT);
							}
							break;
						}
						default:
							if ((LA(1) == IDENT) && (_tokenSet_10.member(LA(2)))) {
								if (inputState.guessing == 0) {
									cls.setType(ClassTypes.NORMAL);
								}
							} else if ((LA(1) == IDENT) && (_tokenSet_10.member(LA(2)))) {
							} else {
								throw new NoViableAltException(LT(1), getFilename());
							}
						}
					}
					i1 = ident();
					if (inputState.guessing == 0) {
						cls.setName(i1);
					}
					{
						switch (LA(1)) {
						case LBRACK: {
							match(LBRACK);
							tnl = typeNameList2();
							match(RBRACK);
							if (inputState.guessing == 0) {
								cls.setGenericPart(tnl);
							}
							break;
						}
						case LPAREN:
						case LCURLY:
						case LT_: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					{
						switch (LA(1)) {
						case LPAREN: {
							{
								match(LPAREN);
								classInheritance_(cls.classInheritance());
								match(RPAREN);
							}
							break;
						}
						case LT_: {
							classInheritanceRuby(cls.classInheritance());
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(LCURLY);
					if (inputState.guessing == 0) {
						cur = cls.getContext();
						ctx = (ClassContext) cur;
					}
					{
						switch (LA(1)) {
						case IDENT:
						case STRING_LITERAL:
						case LITERAL_class:
						case RCURLY:
						case LITERAL_type:
						case ANNOT:
						case LITERAL_namespace:
						case LITERAL_from:
						case LITERAL_import:
						case LITERAL_constructor:
						case LITERAL_ctor:
						case LITERAL_destructor:
						case LITERAL_dtor:
						case LITERAL_const:
						case LITERAL_var:
						case LITERAL_val:
						case LITERAL_alias:
						case LITERAL_invariant:
						case LITERAL_access:
						case LITERAL_def:
						case LITERAL_prop:
						case LITERAL_property: {
							classScope(cls);
							break;
						}
						case LITERAL_abstract: {
							match(LITERAL_abstract);
							if (inputState.guessing == 0) {
								cls.setType(ClassTypes.ABSTRACT);
							}
							{
								switch (LA(1)) {
								case LITERAL_invariant: {
									invariantStatement(cls.invariantStatement());
									break;
								}
								case RCURLY: {
									break;
								}
								default: {
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
							}
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(RCURLY);
					if (inputState.guessing == 0) {
						cls.postConstruct();
						cur = ctx.getParent();
					}
				} else if ((LA(1) == LITERAL_class) && (LA(2) == LITERAL_interface)) {
					if (inputState.guessing == 0) {
						cb = new ClassBuilder();
						cb.annotations(as);
						cb.setParent(parent);
						cb.setParentContext(cur);
					}
					classDefinition_interface(cb);
					if (inputState.guessing == 0) {
						cls = cb.build();
					}
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_11);
			} else {
				throw ex;
			}
		}
		return cls;
	}

	public final TypeNameList typeNameList2() throws RecognitionException, TokenStreamException {
		final TypeNameList cr;

		TypeName tn = null;
		cr = new TypeNameList();

		try {      // for error handling
			tn = typeName2();
			if (inputState.guessing == 0) {
				cr.add(tn);
			}
			{
				do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						tn = typeName2();
						if (inputState.guessing == 0) {
							cr.add(tn);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_12);
			} else {
				throw ex;
			}
		}
		return cr;
	}

	public final void classInheritance_(
	  final ClassInheritance ci
	) throws RecognitionException, TokenStreamException {

		TypeName tn = null;

		try {      // for error handling
			tn = inhTypeName();
			if (inputState.guessing == 0) {
				ci.add(tn);
			}
			{
				do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						tn = inhTypeName();
						if (inputState.guessing == 0) {
							ci.add(tn);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_13);
			} else {
				throw ex;
			}
		}
	}

	public final void classInheritanceRuby(
	  final ClassInheritance ci
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			match(LT_);
			classInheritance_(ci);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_14);
			} else {
				throw ex;
			}
		}
	}

	public final void classScope(
	  final ClassStatement cr
	) throws RecognitionException, TokenStreamException {

		AccessNotation     acs = null;
		TypeAliasStatement tal = null;

		try {      // for error handling
			docstrings(cr);
			{
_loop45:
				do {
					switch (LA(1)) {
					case LITERAL_constructor:
					case LITERAL_ctor: {
						constructorDef(cr);
						break;
					}
					case LITERAL_destructor:
					case LITERAL_dtor: {
						destructorDef(cr);
						break;
					}
					case LITERAL_def: {
						defFunctionDef(cr.defFuncDef());
						break;
					}
					case LITERAL_const:
					case LITERAL_var:
					case LITERAL_val: {
						varStmt(cr.statementClosure(), cr);
						break;
					}
					case LITERAL_prop:
					case LITERAL_property: {
						propertyStatement(cr.prop());
						break;
					}
					case LITERAL_access: {
						acs = accessNotation();
						if (inputState.guessing == 0) {
							cr.addAccess(acs);
						}
						break;
					}
					default:
						if ((LA(1) == IDENT || LA(1) == ANNOT) && (_tokenSet_15.member(LA(2)))) {
							functionDef(cr.funcDef());
						} else if ((LA(1) == LITERAL_type) && (LA(2) == IDENT)) {
							match(LITERAL_type);
							match(IDENT);
							match(BECOMES);
							match(IDENT);
							{
								do {
									if ((LA(1) == BOR)) {
										match(BOR);
										match(IDENT);
									} else {
										break;
									}

								} while (true);
							}
						} else if ((LA(1) == LITERAL_type) && (LA(2) == LITERAL_alias)) {
							tal = typeAlias(cr);
							if (inputState.guessing == 0) {
								cr.add(tal);
							}
						} else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_17.member(LA(2)))) {
							programStatement(cr.XXX(), cr);
						} else {
							break _loop45;
						}
					}
				} while (true);
			}
			{
				switch (LA(1)) {
				case LITERAL_invariant: {
					invariantStatement(cr.invariantStatement());
					break;
				}
				case RCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final void invariantStatement(
	  final InvariantStatement cr
	) throws RecognitionException, TokenStreamException {

		Token                  i1  = null;
		InvariantStatementPart isp = null;

		try {      // for error handling
			match(LITERAL_invariant);
			{
				do {
					if ((_tokenSet_19.member(LA(1)))) {
						if (inputState.guessing == 0) {
							isp = new InvariantStatementPart(cr, i1);
						}
						{
							if ((LA(1) == IDENT) && (LA(2) == TOK_COLON)) {
								i1 = LT(1);
								match(IDENT);
								match(TOK_COLON);
							} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_20.member(LA(2)))) {
							} else {
								throw new NoViableAltException(LT(1), getFilename());
							}

						}
						expr = expression();
						if (inputState.guessing == 0) {
							isp.setExpr(expr);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final void classDefinition_interface(
	  final ClassBuilder cb
	) throws RecognitionException, TokenStreamException {

		IdentExpression    i1  = null;
		final ClassContext ctx = null;
		TypeNameList       tnl = null;

		try {      // for error handling
			match(LITERAL_class);
			match(LITERAL_interface);
			if (inputState.guessing == 0) {
				cb.setType(ClassTypes.INTERFACE);
			}
			i1 = ident();
			if (inputState.guessing == 0) {
				cb.setName(i1);
			}
			{
				switch (LA(1)) {
				case LBRACK: {
					match(LBRACK);
					tnl = typeNameList2();
					match(RBRACK);
					if (inputState.guessing == 0) {
						cb.setGenericPart(tnl);
					}
					break;
				}
				case LPAREN:
				case LCURLY:
				case LT_: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case LPAREN:
				case LT_: {
					classDefinition_inheritance(cb);
					break;
				}
				case LCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(LCURLY);
			classScope2_interface(cb.getScope());
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_3);
			} else {
				throw ex;
			}
		}
	}

	public final void classStatement2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		AnnotationClause a  = null;
		ClassBuilder     cb = null;

		try {      // for error handling
			if (inputState.guessing == 0) {
				cb = new ClassBuilder();
			}
			{
				do {
					if ((LA(1) == ANNOT)) {
						a = annotation_clause();
						if (inputState.guessing == 0) {
							cb.annotation_clause(a);
						}
					} else {
						break;
					}

				} while (true);
			}
			{
				if ((LA(1) == LITERAL_class) && (LA(2) == IDENT)) {
					classDefinition_normal(cb);
				} else if ((LA(1) == LITERAL_class) && (LA(2) == LITERAL_struct)) {
					classDefinition_struct(cb);
				} else if ((LA(1) == LITERAL_class) && (LA(2) == LITERAL_signature)) {
					classDefinition_signature(cb);
				} else if ((LA(1) == LITERAL_class) && (LA(2) == LITERAL_abstract)) {
					classDefinition_abstract(cb);
				} else if ((LA(1) == LITERAL_class) && (LA(2) == LITERAL_interface)) {
					classDefinition_interface(cb);
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_21);
			} else {
				throw ex;
			}
		}
	}

	public final AnnotationClause annotation_clause() throws RecognitionException, TokenStreamException {
		final AnnotationClause a;

		Qualident      q  = null;
		ExpressionList el = null;
		a = new AnnotationClause();
		AnnotationPart ap = null;

		try {      // for error handling
			match(ANNOT);
			{
				int _cnt68 = 0;
				do {
					if ((LA(1) == IDENT)) {
						if (inputState.guessing == 0) {
							ap = new AnnotationPart();
						}
						q = qualident();
						if (inputState.guessing == 0) {
							ap.setClass(q);
						}
						{
							switch (LA(1)) {
							case LPAREN: {
								match(LPAREN);
								el = expressionList();
								match(RPAREN);
								if (inputState.guessing == 0) {
									ap.setExprs(el);
								}
								break;
							}
							case IDENT:
							case RBRACK: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						if (inputState.guessing == 0) {
							a.add(ap);
						}
					} else {
						if (_cnt68 >= 1) {
							break;
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}
					}

					_cnt68++;
				} while (true);
			}
			match(RBRACK);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_22);
			} else {
				throw ex;
			}
		}
		return a;
	}

	public final void classDefinition_normal(
	  final ClassBuilder cb
	) throws RecognitionException, TokenStreamException {

		IdentExpression    i1  = null;
		final ClassContext ctx = null;
		TypeNameList       tnl = null;

		try {      // for error handling
			match(LITERAL_class);
			if (inputState.guessing == 0) {
				cb.setType(ClassTypes.NORMAL);
			}
			i1 = ident();
			if (inputState.guessing == 0) {
				cb.setName(i1);
			}
			{
				switch (LA(1)) {
				case LBRACK: {
					match(LBRACK);
					tnl = typeNameList2();
					match(RBRACK);
					if (inputState.guessing == 0) {
						cb.setGenericPart(tnl);
					}
					break;
				}
				case LPAREN:
				case LCURLY:
				case LT_: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case LPAREN:
				case LT_: {
					classDefinition_inheritance(cb);
					break;
				}
				case LCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(LCURLY);
			{
				classScope2(cb.getScope());
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_21);
			} else {
				throw ex;
			}
		}
	}

	public final void classDefinition_struct(
	  final ClassBuilder cb
	) throws RecognitionException, TokenStreamException {

		IdentExpression    i1  = null;
		final ClassContext ctx = null;

		try {      // for error handling
			match(LITERAL_class);
			match(LITERAL_struct);
			if (inputState.guessing == 0) {
				cb.setType(ClassTypes.STRUCTURE);
			}
			i1 = ident();
			if (inputState.guessing == 0) {
				cb.setName(i1);
			}
			{
				switch (LA(1)) {
				case LPAREN:
				case LT_: {
					classDefinition_inheritance(cb);
					break;
				}
				case LCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(LCURLY);
			classScope2(cb.getScope());
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_21);
			} else {
				throw ex;
			}
		}
	}

	public final void classDefinition_signature(
	  final ClassBuilder cb
	) throws RecognitionException, TokenStreamException {

		IdentExpression    i1  = null;
		final ClassContext ctx = null;

		try {      // for error handling
			match(LITERAL_class);
			match(LITERAL_signature);
			if (inputState.guessing == 0) {
				cb.setType(ClassTypes.SIGNATURE);
			}
			i1 = ident();
			if (inputState.guessing == 0) {
				cb.setName(i1);
			}
			{
				switch (LA(1)) {
				case LPAREN:
				case LT_: {
					classDefinition_inheritance(cb);
					break;
				}
				case LCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(LCURLY);
			classScope2_signature(cb.getScope());
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_21);
			} else {
				throw ex;
			}
		}
	}

	public final void classDefinition_abstract(
	  final ClassBuilder cb
	) throws RecognitionException, TokenStreamException {

		final ClassStatement cls = null;
		IdentExpression      i1  = null;

		try {      // for error handling
			match(LITERAL_class);
			match(LITERAL_abstract);
			if (inputState.guessing == 0) {
				cb.setType(ClassTypes.ABSTRACT);
			}
			i1 = ident();
			if (inputState.guessing == 0) {
				cb.setName(i1);
			}
			{
				switch (LA(1)) {
				case LPAREN:
				case LT_: {
					classDefinition_inheritance(cb);
					break;
				}
				case LCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(LCURLY);
			{
				switch (LA(1)) {
				case IDENT:
				case STRING_LITERAL:
				case LITERAL_class:
				case RCURLY:
				case LITERAL_type:
				case ANNOT:
				case LITERAL_namespace:
				case LITERAL_from:
				case LITERAL_import:
				case LITERAL_constructor:
				case LITERAL_ctor:
				case LITERAL_destructor:
				case LITERAL_dtor:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_alias:
				case LITERAL_invariant:
				case LITERAL_access: {
					classScope2(cb.getScope());
					break;
				}
				case LITERAL_abstract: {
					match(LITERAL_abstract);
					if (inputState.guessing == 0) {
						cls.setType(ClassTypes.ABSTRACT);
					}
					{
						switch (LA(1)) {
						case LITERAL_invariant: {
							invariantStatement2(cb.getScope());
							break;
						}
						case RCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_21);
			} else {
				throw ex;
			}
		}
	}

	public final void classDefinition_inheritance(
	  final ClassBuilder cb
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			switch (LA(1)) {
			case LPAREN: {
				{
					match(LPAREN);
					classInheritance_(cb.classInheritance());
					match(RPAREN);
				}
				break;
			}
			case LT_: {
				classInheritanceRuby(cb.classInheritance());
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_14);
			} else {
				throw ex;
			}
		}
	}

	public final void classScope2(
	  final ClassScope cr
	) throws RecognitionException, TokenStreamException {

		AccessNotation acs = null;

		try {      // for error handling
			docstrings(cr);
			{
_loop51:
				do {
					switch (LA(1)) {
					case LITERAL_constructor:
					case LITERAL_ctor: {
						constructorDef2(cr);
						break;
					}
					case LITERAL_destructor:
					case LITERAL_dtor: {
						destructorDef2(cr);
						break;
					}
					case LITERAL_const:
					case LITERAL_var:
					case LITERAL_val: {
						varStmt2(cr);
						break;
					}
					case LITERAL_access: {
						acs = accessNotation();
						if (inputState.guessing == 0) {
							cr.addAccess(acs);
						}
						break;
					}
					default:
						if ((LA(1) == IDENT || LA(1) == ANNOT) && (_tokenSet_15.member(LA(2)))) {
							functionDef2(cr.funcDef());
						} else if ((LA(1) == LITERAL_type) && (LA(2) == IDENT)) {
							match(LITERAL_type);
							match(IDENT);
							match(BECOMES);
							match(IDENT);
							{
								do {
									if ((LA(1) == BOR)) {
										match(BOR);
										match(IDENT);
									} else {
										break;
									}

								} while (true);
							}
						} else if ((LA(1) == LITERAL_type) && (LA(2) == LITERAL_alias)) {
							typeAlias2(cr.typeAlias());
						} else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_23.member(LA(2)))) {
							programStatement2(cr);
						} else {
							break _loop51;
						}
					}
				} while (true);
			}
			{
				switch (LA(1)) {
				case LITERAL_invariant: {
					invariantStatement2(cr);
					break;
				}
				case RCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final void classScope2_signature(
	  final ClassScope cr
	) throws RecognitionException, TokenStreamException {

		AccessNotation acs = null;

		try {      // for error handling
			docstrings(cr);
			{
				do {
					if ((_tokenSet_24.member(LA(1))) && (_tokenSet_25.member(LA(2)))) {
					} else if ((LA(1) == IDENT || LA(1) == ANNOT) && (_tokenSet_15.member(LA(2)))) {
						functionDef2(cr.funcDef());
					} else if ((LA(1) == LITERAL_const || LA(1) == LITERAL_var || LA(1) == LITERAL_val) && (LA(2) == IDENT)) {
						varStmt2(cr);
					} else if ((LA(1) == LITERAL_type) && (LA(2) == IDENT)) {
						match(LITERAL_type);
						match(IDENT);
						match(BECOMES);
						match(IDENT);
						{
							do {
								if ((LA(1) == BOR)) {
									match(BOR);
									match(IDENT);
								} else {
									break;
								}

							} while (true);
						}
					} else if ((LA(1) == LITERAL_type) && (LA(2) == LITERAL_alias)) {
						typeAlias2(cr.typeAlias());
					} else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_26.member(LA(2)))) {
						programStatement2(cr);
					} else if ((LA(1) == LITERAL_access) && (LA(2) == IDENT || LA(2) == STRING_LITERAL || LA(2) == LCURLY)) {
						acs = accessNotation();
						if (inputState.guessing == 0) {
							cr.addAccess(acs);
						}
					} else {
						break;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case LITERAL_invariant: {
					invariantStatement2(cr);
					break;
				}
				case RCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final void invariantStatement2(
	  final ClassScope sc
	) throws RecognitionException, TokenStreamException {

		final InvariantStatementPart isp = null;
		IdentExpression              i1  = null;

		try {      // for error handling
			match(LITERAL_invariant);
			{
				do {
					if ((_tokenSet_19.member(LA(1)))) {
						{
							if ((LA(1) == IDENT) && (LA(2) == TOK_COLON)) {
								i1 = ident();
								match(TOK_COLON);
							} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_20.member(LA(2)))) {
								if (inputState.guessing == 0) {
									i1 = null;
								}
							} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_20.member(LA(2)))) {
							} else {
								throw new NoViableAltException(LT(1), getFilename());
							}

						}
						expr = expression();
						if (inputState.guessing == 0) {
							sc.addInvariantStatementPart(i1, expr);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final void classScope2_interface(
	  final ClassScope cr
	) throws RecognitionException, TokenStreamException {

		AccessNotation acs = null;

		try {      // for error handling
			docstrings(cr);
			{
_loop63:
				do {
					switch (LA(1)) {
					case LITERAL_const:
					case LITERAL_var:
					case LITERAL_val: {
						varStmt2(cr);
						break;
					}
					case LITERAL_access: {
						acs = accessNotation();
						if (inputState.guessing == 0) {
							cr.addAccess(acs);
						}
						break;
					}
					default:
						if ((LA(1) == IDENT || LA(1) == ANNOT) && (_tokenSet_15.member(LA(2)))) {
							functionDef2_interface(cr.funcDef());
						} else if ((LA(1) == LITERAL_type) && (LA(2) == IDENT)) {
							match(LITERAL_type);
							match(IDENT);
							match(BECOMES);
							match(IDENT);
							{
								do {
									if ((LA(1) == BOR)) {
										match(BOR);
										match(IDENT);
									} else {
										break;
									}

								} while (true);
							}
						} else if ((LA(1) == LITERAL_type) && (LA(2) == LITERAL_alias)) {
							typeAlias2(cr.typeAlias());
						} else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_27.member(LA(2)))) {
							programStatement2(cr);
						} else if ((LA(1) == LITERAL_prop || LA(1) == LITERAL_property) && (LA(2) == IDENT)) {
							propertyStatement2_abstract(cr);
						} else if ((LA(1) == LITERAL_prop || LA(1) == LITERAL_property) && (LA(2) == IDENT)) {
							propertyStatement2(cr);
						} else {
							break _loop63;
						}
					}
				} while (true);
			}
			{
				switch (LA(1)) {
				case LITERAL_invariant: {
					invariantStatement2(cr);
					break;
				}
				case RCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final void docstrings(
	  final Documentable sc
	) throws RecognitionException, TokenStreamException {

		Token s1 = null;

		try {      // for error handling
			{
				boolean synPredMatched112 = false;
				if (((LA(1) == STRING_LITERAL) && (_tokenSet_28.member(LA(2))))) {
					final int _m112 = mark();
					synPredMatched112 = true;
					inputState.guessing++;
					try {
						{
							match(STRING_LITERAL);
						}
					} catch (final RecognitionException pe) {
						synPredMatched112 = false;
					}
					rewind(_m112);
					inputState.guessing--;
				}
				if (synPredMatched112) {
					{
						int _cnt114 = 0;
						do {
							if ((LA(1) == STRING_LITERAL) && (_tokenSet_28.member(LA(2)))) {
								s1 = LT(1);
								match(STRING_LITERAL);
								if (inputState.guessing == 0) {
									if (sc != null) sc.addDocString(s1);
								}
							} else {
								if (_cnt114 >= 1) {
									break;
								} else {
									throw new NoViableAltException(LT(1), getFilename());
								}
							}

							_cnt114++;
						} while (true);
					}
				} else if ((_tokenSet_28.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_28);
			} else {
				throw ex;
			}
		}
	}

	public final void constructorDef(
	  final ClassStatement cr
	) throws RecognitionException, TokenStreamException {

		ConstructorDef  cd  = null;
		IdentExpression x1  = null;
		FormalArgList   fal = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_constructor: {
					match(LITERAL_constructor);
					break;
				}
				case LITERAL_ctor: {
					match(LITERAL_ctor);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case IDENT: {
					x1 = ident();
					if (inputState.guessing == 0) {
						cd = cr.addCtor(x1);
					}
					break;
				}
				case LPAREN: {
					if (inputState.guessing == 0) {
						cd = cr.addCtor(null);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			fal = opfal();
			if (inputState.guessing == 0) {
				cd.setFal(fal);
			}
			sco = scope3(cd);
			if (inputState.guessing == 0) {
				cd.scope(sco);
			}
			if (inputState.guessing == 0) {
				cd.postConstruct();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_29);
			} else {
				throw ex;
			}
		}
	}

	public final void destructorDef(
	  final ClassStatement cr
	) throws RecognitionException, TokenStreamException {

		DestructorDef dd  = null;
		FormalArgList fal = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_destructor: {
					match(LITERAL_destructor);
					break;
				}
				case LITERAL_dtor: {
					match(LITERAL_dtor);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				dd = cr.addDtor();
			}
			fal = opfal();
			if (inputState.guessing == 0) {
				dd.setFal(fal);
			}
			sco = scope3(dd);
			if (inputState.guessing == 0) {
				dd.scope(sco);
			}
			if (inputState.guessing == 0) {
				dd.postConstruct();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_29);
			} else {
				throw ex;
			}
		}
	}

	public final void functionDef(
	  final FunctionDef fd
	) throws RecognitionException, TokenStreamException {

		AnnotationClause a   = null;
		FunctionContext  ctx = null;
		IdentExpression  i1  = null;
		TypeName         tn  = null;
		FormalArgList    fal = null;

		try {      // for error handling
			{
				do {
					if ((LA(1) == ANNOT)) {
						a = annotation_clause();
						if (inputState.guessing == 0) {
							fd.addAnnotation(a);
						}
					} else {
						break;
					}

				} while (true);
			}
			i1 = ident();
			if (inputState.guessing == 0) {
				fd.setName(i1);
			}
			{
				switch (LA(1)) {
				case LITERAL_const: {
					match(LITERAL_const);
					if (inputState.guessing == 0) {
						fd.set(FunctionModifiers.CONST);
					}
					break;
				}
				case LITERAL_immutable: {
					match(LITERAL_immutable);
					if (inputState.guessing == 0) {
						fd.set(FunctionModifiers.IMMUTABLE);
					}
					break;
				}
				case LPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			fal = opfal();
			if (inputState.guessing == 0) {
				fd.setFal(fal);
			}
			{
				switch (LA(1)) {
				case TOK_ARROW: {
					match(TOK_ARROW);
					tn = typeName2();
					if (inputState.guessing == 0) {
						fd.setReturnType(tn);
					}
					break;
				}
				case LCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				ctx = (FunctionContext) fd.getContext();
				cur = ctx;
			}
			sco = functionScope(fd);
			if (inputState.guessing == 0) {
				fd.scope(sco);
			}
			if (inputState.guessing == 0) {
				fd.setSpecies(FunctionDef.Species.REG_FUN);
				fd.postConstruct();
				cur = ctx.getParent();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_30);
			} else {
				throw ex;
			}
		}
	}

	public final void defFunctionDef(
	  final DefFunctionDef fd
	) throws RecognitionException, TokenStreamException {

		FormalArgList   op = null;
		TypeName        tn = null;
		IdentExpression i1 = null;

		try {      // for error handling
			match(LITERAL_def);
			i1 = ident();
			op = opfal();
			{
				switch (LA(1)) {
				case TOK_COLON:
				case TOK_ARROW: {
					{
						switch (LA(1)) {
						case TOK_COLON: {
							match(TOK_COLON);
							break;
						}
						case TOK_ARROW: {
							match(TOK_ARROW);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					tn = typeName2();
					if (inputState.guessing == 0) {
						fd.setReturnType(tn);
					}
					break;
				}
				case BECOMES: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(BECOMES);
			expr = expression();
			if (inputState.guessing == 0) {
				fd.setSpecies(FunctionDef.Species.DEF_FUN);
				fd.setName(i1);
				fd.setFal(op);
				fd.setExpr(expr);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_29);
			} else {
				throw ex;
			}
		}
	}

	public final void varStmt(
	  final StatementClosure cr, final OS_Element aParent
	) throws RecognitionException, TokenStreamException {

		VariableSequence vsq = null;
		TypeName         tn  = null;

		try {      // for error handling
			if (inputState.guessing == 0) {
				vsq = cr.varSeq(cur);
			}
			{
				switch (LA(1)) {
				case LITERAL_var: {
					match(LITERAL_var);
					break;
				}
				case LITERAL_const: {
					match(LITERAL_const);
					if (inputState.guessing == 0) {
						vsq.defaultModifiers(TypeModifiers.CONST);
					}
					break;
				}
				case LITERAL_val: {
					match(LITERAL_val);
					if (inputState.guessing == 0) {
						vsq.defaultModifiers(TypeModifiers.VAL);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				varStmt_i3(vsq.next());
				{
					do {
						if ((LA(1) == COMMA)) {
							match(COMMA);
							varStmt_i3(vsq.next());
						} else {
							break;
						}

					} while (true);
				}
				{
					switch (LA(1)) {
					case TOK_COLON: {
						match(TOK_COLON);
						tn = typeName2();
						if (inputState.guessing == 0) {
							vsq.setTypeName(tn);
						}
						break;
					}
					case IDENT:
					case STRING_LITERAL:
					case CHAR_LITERAL:
					case NUM_INT:
					case NUM_FLOAT:
					case LITERAL_class:
					case LBRACK:
					case LPAREN:
					case LCURLY:
					case RCURLY:
					case LITERAL_type:
					case ANNOT:
					case LITERAL_namespace:
					case LITERAL_from:
					case LITERAL_import:
					case LITERAL_constructor:
					case LITERAL_ctor:
					case LITERAL_destructor:
					case LITERAL_dtor:
					case LITERAL_continue:
					case LITERAL_break:
					case LITERAL_return:
					case LITERAL_with:
					case LITERAL_const:
					case LITERAL_var:
					case LITERAL_val:
					case LITERAL_alias:
					case LITERAL_yield:
					case LITERAL_construct:
					case SEMI:
					case LITERAL_invariant:
					case LITERAL_access:
					case PLUS:
					case MINUS:
					case INC:
					case DEC:
					case BNOT:
					case LNOT:
					case LITERAL_true:
					case LITERAL_false:
					case LITERAL_this:
					case LITERAL_null:
					case LITERAL_function:
					case LITERAL_procedure:
					case LITERAL_if:
					case LITERAL_match:
					case LITERAL_case:
					case LITERAL_while:
					case LITERAL_do:
					case LITERAL_iterate:
					case LITERAL_def:
					case LITERAL_prop:
					case LITERAL_property: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_31);
			} else {
				throw ex;
			}
		}
	}

	public final TypeAliasStatement typeAlias(
	  final OS_Element cont
	) throws RecognitionException, TokenStreamException {
		TypeAliasStatement cr;

		final TypeAliasBuilder tab = new TypeAliasBuilder();
		cr = null;

		try {      // for error handling
			typeAlias2(tab);
			if (inputState.guessing == 0) {
				tab.setParent(cont);
				tab.setContext(cur);
				cr = tab.build();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_30);
			} else {
				throw ex;
			}
		}
		return cr;
	}

	public final void propertyStatement(
	  final PropertyStatement ps
	) throws RecognitionException, TokenStreamException {

		IdentExpression prop_name = null;
		TypeName        tn        = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_prop: {
					match(LITERAL_prop);
					break;
				}
				case LITERAL_property: {
					match(LITERAL_property);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			prop_name = ident();
			if (inputState.guessing == 0) {
				ps.setName(prop_name);
			}
			{
				switch (LA(1)) {
				case TOK_COLON: {
					match(TOK_COLON);
					break;
				}
				case TOK_ARROW: {
					match(TOK_ARROW);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			tn = typeName2();
			if (inputState.guessing == 0) {
				ps.setTypeName(tn);
			}
			match(LCURLY);
			{
_loop440:
				do {
					switch (LA(1)) {
					case LITERAL_get: {
						match(LITERAL_get);
						{
							switch (LA(1)) {
							case SEMI: {
								match(SEMI);
								if (inputState.guessing == 0) {
									ps.addGet();
								}
								break;
							}
							case LCURLY: {
								sco = scope3(ps);
								if (inputState.guessing == 0) {
									ps.get_scope(sco);
								}
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						break;
					}
					case LITERAL_set: {
						match(LITERAL_set);
						{
							switch (LA(1)) {
							case SEMI: {
								match(SEMI);
								if (inputState.guessing == 0) {
									ps.addSet();
								}
								break;
							}
							case LCURLY: {
								sco = scope3(ps);
								if (inputState.guessing == 0) {
									ps.set_scope(sco);
								}
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						break;
					}
					default: {
						break _loop440;
					}
					}
				} while (true);
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_29);
			} else {
				throw ex;
			}
		}
	}

	public final AccessNotation accessNotation() throws RecognitionException, TokenStreamException {
		final AccessNotation acs;

		Token        category   = null;
		Token        shorthand  = null;
		Token        category1  = null;
		Token        shorthand1 = null;
		TypeNameList tnl        = null;
		acs = new AccessNotation();

		try {      // for error handling
			match(LITERAL_access);
			{
				if ((LA(1) == STRING_LITERAL) && (LA(2) == IDENT || LA(2) == LCURLY)) {
					category = LT(1);
					match(STRING_LITERAL);
					{
						switch (LA(1)) {
						case IDENT: {
							shorthand = LT(1);
							match(IDENT);
							match(EQUAL);
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(LCURLY);
					tnl = typeNameList2();
					match(RCURLY);
					if (inputState.guessing == 0) {
						acs.setCategory(category);
						acs.setShortHand(shorthand);
						acs.setTypeNames(tnl);
					}
				} else if ((LA(1) == STRING_LITERAL) && (_tokenSet_30.member(LA(2)))) {
					category1 = LT(1);
					match(STRING_LITERAL);
					if (inputState.guessing == 0) {
						acs.setCategory(category1);
					}
				} else if ((LA(1) == IDENT || LA(1) == LCURLY)) {
					{
						switch (LA(1)) {
						case IDENT: {
							shorthand1 = LT(1);
							match(IDENT);
							match(EQUAL);
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(LCURLY);
					tnl = typeNameList2();
					match(RCURLY);
					if (inputState.guessing == 0) {
						acs.setShortHand(shorthand1);
						acs.setTypeNames(tnl);
					}
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			opt_semi();
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_30);
			} else {
				throw ex;
			}
		}
		return acs;
	}

	public final void constructorDef2(
	  final ClassScope cr
	) throws RecognitionException, TokenStreamException {

		final ConstructorDefBuilder cd  = new ConstructorDefBuilder();
		IdentExpression             x1  = null;
		FormalArgList               fal = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_constructor: {
					match(LITERAL_constructor);
					break;
				}
				case LITERAL_ctor: {
					match(LITERAL_ctor);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case IDENT: {
					x1 = ident();
					if (inputState.guessing == 0) {
						cd.setName(x1);
					}
					break;
				}
				case LPAREN: {
					if (inputState.guessing == 0) {
						cd.setName(null);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			fal = opfal();
			if (inputState.guessing == 0) {
				cd.fal(fal);
			}
			constructor_scope2(cd.scope());
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_32);
			} else {
				throw ex;
			}
		}
	}

	public final void destructorDef2(
	  final ClassScope cr
	) throws RecognitionException, TokenStreamException {

		final DestructorDefBuilder dd  = new DestructorDefBuilder();
		FormalArgList              fal = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_destructor: {
					match(LITERAL_destructor);
					break;
				}
				case LITERAL_dtor: {
					match(LITERAL_dtor);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			fal = opfal();
			if (inputState.guessing == 0) {
				dd.fal(fal);
			}
			scope2(dd.scope());
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_32);
			} else {
				throw ex;
			}
		}
	}

	public final void functionDef2(
	  final FunctionDefBuilder fb
	) throws RecognitionException, TokenStreamException {

		AnnotationClause a   = null;
		IdentExpression  i1  = null;
		TypeName         tn  = null;
		FormalArgList    fal = null;

		try {      // for error handling
			{
				do {
					if ((LA(1) == ANNOT)) {
						a = annotation_clause();
						if (inputState.guessing == 0) {
							fb.addAnnotation(a);
						}
					} else {
						break;
					}

				} while (true);
			}
			i1 = ident();
			if (inputState.guessing == 0) {
				fb.setName(i1);
			}
			{
				switch (LA(1)) {
				case LITERAL_const: {
					match(LITERAL_const);
					if (inputState.guessing == 0) {
						fb.set(FunctionModifiers.CONST);
					}
					break;
				}
				case LITERAL_immutable: {
					match(LITERAL_immutable);
					if (inputState.guessing == 0) {
						fb.set(FunctionModifiers.IMMUTABLE);
					}
					break;
				}
				case LPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			fal = opfal();
			if (inputState.guessing == 0) {
				fb.fal(fal);
			}
			{
				switch (LA(1)) {
				case TOK_ARROW: {
					match(TOK_ARROW);
					tn = typeName2();
					if (inputState.guessing == 0) {
						fb.setReturnType(tn);
					}
					break;
				}
				case LCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			functionScope2(fb.scope());
			if (inputState.guessing == 0) {
				fb.setSpecies(FunctionDef.Species.DEF_FUN);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_33);
			} else {
				throw ex;
			}
		}
	}

	public final void varStmt2(
	  final BaseScope cs
	) throws RecognitionException, TokenStreamException {

		final VariableSequenceBuilder vsqb = new VariableSequenceBuilder();
		TypeName                      tn   = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_var: {
					match(LITERAL_var);
					break;
				}
				case LITERAL_const: {
					match(LITERAL_const);
					if (inputState.guessing == 0) {
						vsqb.defaultModifiers(TypeModifiers.CONST);
					}
					break;
				}
				case LITERAL_val: {
					match(LITERAL_val);
					if (inputState.guessing == 0) {
						vsqb.defaultModifiers(TypeModifiers.VAL);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				varStmt_i2(vsqb);
				{
					do {
						if ((LA(1) == COMMA)) {
							if (inputState.guessing == 0) {
								vsqb.next();
							}
							match(COMMA);
							varStmt_i2(vsqb);
						} else {
							break;
						}

					} while (true);
				}
				{
					switch (LA(1)) {
					case TOK_COLON: {
						match(TOK_COLON);
						tn = typeName2();
						if (inputState.guessing == 0) {
							vsqb.setTypeName(tn);
						}
						break;
					}
					case IDENT:
					case STRING_LITERAL:
					case CHAR_LITERAL:
					case NUM_INT:
					case NUM_FLOAT:
					case LITERAL_class:
					case LBRACK:
					case LPAREN:
					case LCURLY:
					case RCURLY:
					case LITERAL_type:
					case ANNOT:
					case LITERAL_namespace:
					case LITERAL_from:
					case LITERAL_import:
					case LITERAL_constructor:
					case LITERAL_ctor:
					case LITERAL_destructor:
					case LITERAL_dtor:
					case LITERAL_continue:
					case LITERAL_break:
					case LITERAL_return:
					case LITERAL_with:
					case LITERAL_post:
					case LITERAL_const:
					case LITERAL_var:
					case LITERAL_val:
					case LITERAL_alias:
					case LITERAL_yield:
					case LITERAL_construct:
					case SEMI:
					case LITERAL_invariant:
					case LITERAL_access:
					case PLUS:
					case MINUS:
					case INC:
					case DEC:
					case BNOT:
					case LNOT:
					case LITERAL_true:
					case LITERAL_false:
					case LITERAL_this:
					case LITERAL_null:
					case LITERAL_function:
					case LITERAL_procedure:
					case LITERAL_if:
					case LITERAL_match:
					case LITERAL_case:
					case LITERAL_while:
					case LITERAL_do:
					case LITERAL_iterate:
					case LITERAL_prop:
					case LITERAL_property: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			}
			if (inputState.guessing == 0) {
				cs.add(vsqb);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_21);
			} else {
				throw ex;
			}
		}
	}

	public final void typeAlias2(
	  final TypeAliasBuilder tab
	) throws RecognitionException, TokenStreamException {

		Qualident       q = null;
		IdentExpression i = null;

		try {      // for error handling
			match(LITERAL_type);
			match(LITERAL_alias);
			i = ident();
			if (inputState.guessing == 0) {
				tab.setIdent(i);
			}
			match(BECOMES);
			q = qualident();
			if (inputState.guessing == 0) {
				tab.setBecomes(q);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_30);
			} else {
				throw ex;
			}
		}
	}

	public final void programStatement2(
	  final ClassOrNamespaceScope cont
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			switch (LA(1)) {
			case LITERAL_from:
			case LITERAL_import: {
				importStatement2(cont);
				break;
			}
			case LITERAL_alias: {
				aliasStatement2(cont);
				break;
			}
			default:
				if ((LA(1) == ANNOT || LA(1) == LITERAL_namespace) && (LA(2) == IDENT || LA(2) == LCURLY)) {
					namespaceStatement2(cont);
				} else if ((LA(1) == LITERAL_class || LA(1) == ANNOT) && (_tokenSet_34.member(LA(2)))) {
					classStatement2(cont);
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_35);
			} else {
				throw ex;
			}
		}
	}

	public final void functionDef2_interface(
	  final FunctionDefBuilder fb
	) throws RecognitionException, TokenStreamException {

		AnnotationClause a   = null;
		IdentExpression  i1  = null;
		TypeName         tn  = null;
		FormalArgList    fal = null;

		try {      // for error handling
			{
				do {
					if ((LA(1) == ANNOT)) {
						a = annotation_clause();
						if (inputState.guessing == 0) {
							fb.addAnnotation(a);
						}
					} else {
						break;
					}

				} while (true);
			}
			i1 = ident();
			if (inputState.guessing == 0) {
				fb.setName(i1);
			}
			{
				switch (LA(1)) {
				case LITERAL_const: {
					match(LITERAL_const);
					if (inputState.guessing == 0) {
						fb.set(FunctionModifiers.CONST);
					}
					break;
				}
				case LITERAL_immutable: {
					match(LITERAL_immutable);
					if (inputState.guessing == 0) {
						fb.set(FunctionModifiers.IMMUTABLE);
					}
					break;
				}
				case LPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			fal = opfal();
			if (inputState.guessing == 0) {
				fb.fal(fal);
			}
			{
				switch (LA(1)) {
				case TOK_ARROW: {
					match(TOK_ARROW);
					tn = typeName2();
					if (inputState.guessing == 0) {
						fb.setReturnType(tn);
					}
					break;
				}
				case IDENT:
				case LITERAL_class:
				case LCURLY:
				case RCURLY:
				case LITERAL_type:
				case ANNOT:
				case LITERAL_namespace:
				case LITERAL_from:
				case LITERAL_import:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_alias:
				case LITERAL_invariant:
				case LITERAL_access:
				case LITERAL_prop:
				case LITERAL_property: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case LCURLY: {
					functionScope2(fb.scope());
					break;
				}
				case IDENT:
				case LITERAL_class:
				case RCURLY:
				case LITERAL_type:
				case ANNOT:
				case LITERAL_namespace:
				case LITERAL_from:
				case LITERAL_import:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_alias:
				case LITERAL_invariant:
				case LITERAL_access:
				case LITERAL_prop:
				case LITERAL_property: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				fb.setSpecies(FunctionDef.Species.REG_FUN);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_36);
			} else {
				throw ex;
			}
		}
	}

	public final void propertyStatement2_abstract(
	  final ClassScope cr
	) throws RecognitionException, TokenStreamException {

		final PropertyStatementBuilder ps        = new PropertyStatementBuilder();
		IdentExpression                prop_name = null;
		TypeName                       tn        = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_prop: {
					match(LITERAL_prop);
					break;
				}
				case LITERAL_property: {
					match(LITERAL_property);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			prop_name = ident();
			if (inputState.guessing == 0) {
				ps.setName(prop_name);
			}
			{
				switch (LA(1)) {
				case TOK_COLON: {
					match(TOK_COLON);
					break;
				}
				case TOK_ARROW: {
					match(TOK_ARROW);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			tn = typeName2();
			if (inputState.guessing == 0) {
				ps.setTypeName(tn);
			}
			match(LCURLY);
			{
_loop445:
				do {
					switch (LA(1)) {
					case LITERAL_get: {
						match(LITERAL_get);
						match(SEMI);
						if (inputState.guessing == 0) {
							ps.addGet();
						}
						break;
					}
					case LITERAL_set: {
						match(LITERAL_set);
						match(SEMI);
						if (inputState.guessing == 0) {
							ps.addSet();
						}
						break;
					}
					default: {
						break _loop445;
					}
					}
				} while (true);
			}
			match(RCURLY);
			if (inputState.guessing == 0) {
				cr.addProp(ps);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_36);
			} else {
				throw ex;
			}
		}
	}

	public final void propertyStatement2(
	  final ClassScope cr
	) throws RecognitionException, TokenStreamException {

		final PropertyStatementBuilder ps        = new PropertyStatementBuilder();
		IdentExpression                prop_name = null;
		TypeName                       tn        = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_prop: {
					match(LITERAL_prop);
					break;
				}
				case LITERAL_property: {
					match(LITERAL_property);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			prop_name = ident();
			if (inputState.guessing == 0) {
				ps.setName(prop_name);
			}
			{
				switch (LA(1)) {
				case TOK_COLON: {
					match(TOK_COLON);
					break;
				}
				case TOK_ARROW: {
					match(TOK_ARROW);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			tn = typeName2();
			if (inputState.guessing == 0) {
				ps.setTypeName(tn);
			}
			match(LCURLY);
			{
_loop452:
				do {
					switch (LA(1)) {
					case LITERAL_get: {
						match(LITERAL_get);
						{
							switch (LA(1)) {
							case SEMI: {
								match(SEMI);
								if (inputState.guessing == 0) {
									ps.addGet();
								}
								break;
							}
							case LCURLY: {
								scope2(ps.get_scope());
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						break;
					}
					case LITERAL_set: {
						match(LITERAL_set);
						{
							switch (LA(1)) {
							case SEMI: {
								match(SEMI);
								if (inputState.guessing == 0) {
									ps.addSet();
								}
								break;
							}
							case LCURLY: {
								scope2(ps.set_scope());
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						break;
					}
					default: {
						break _loop452;
					}
					}
				} while (true);
			}
			match(RCURLY);
			if (inputState.guessing == 0) {
				cr.addProp(ps);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_36);
			} else {
				throw ex;
			}
		}
	}

	public final void namespaceStatement__(
	  final NamespaceStatement cls, final List<AnnotationClause> as
	) throws RecognitionException, TokenStreamException {

		final AnnotationClause a   = null;
		NamespaceContext       ctx = null;
		IdentExpression        i1  = null;

		try {      // for error handling
			if (inputState.guessing == 0) {
				cls.addAnnotations(as);
			}
			match(LITERAL_namespace);
			{
				if ((LA(1) == IDENT)) {
					i1 = ident();
					if (inputState.guessing == 0) {
						cls.setName(i1);
					}
				} else if ((LA(1) == LCURLY) && (_tokenSet_37.member(LA(2)))) {
					if (inputState.guessing == 0) {
						cls.setType(NamespaceTypes.MODULE);
					}
				} else if ((LA(1) == LCURLY) && (_tokenSet_37.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			match(LCURLY);
			if (inputState.guessing == 0) {
				ctx = new NamespaceContext(cur, cls);
				cls.setContext(ctx);
				cur = ctx;
			}
			namespaceScope(cls);
			match(RCURLY);
			if (inputState.guessing == 0) {
				cls.postConstruct();
				cur = ctx.getParent();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_5);
			} else {
				throw ex;
			}
		}
	}

	public final void namespaceScope(
	  final NamespaceStatement cr
	) throws RecognitionException, TokenStreamException {

		AccessNotation     acs = null;
		TypeAliasStatement tal = null;

		try {      // for error handling
			docstrings(cr);
			{
				do {
					if ((_tokenSet_38.member(LA(1)))) {
						{
							switch (LA(1)) {
							case LITERAL_const:
							case LITERAL_var:
							case LITERAL_val: {
								varStmt(cr.statementClosure(), cr);
								break;
							}
							case LITERAL_type: {
								tal = typeAlias(cr);
								if (inputState.guessing == 0) {
									cr.add(tal);
								}
								break;
							}
							case LITERAL_access: {
								acs = accessNotation();
								if (inputState.guessing == 0) {
									cr.addAccess(acs);
								}
								break;
							}
							default:
								if ((LA(1) == IDENT || LA(1) == ANNOT) && (_tokenSet_15.member(LA(2)))) {
									functionDef(cr.funcDef());
								} else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_17.member(LA(2)))) {
									programStatement(cr.XXX(), cr);
								} else {
									throw new NoViableAltException(LT(1), getFilename());
								}
							}
						}
						opt_semi();
					} else {
						break;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case LITERAL_invariant: {
					invariantStatement(cr.invariantStatement());
					break;
				}
				case RCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final void namespaceStatement2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final NamespaceStatementBuilder cls = new NamespaceStatementBuilder();
		AnnotationClause                a   = null;
		final NamespaceContext          ctx = null;
		IdentExpression                 i1  = null;

		try {      // for error handling
			{
				do {
					if ((LA(1) == ANNOT)) {
						a = annotation_clause();
						if (inputState.guessing == 0) {
							cls.annotations(a);
						}
					} else {
						break;
					}

				} while (true);
			}
			match(LITERAL_namespace);
			{
				if ((LA(1) == IDENT)) {
					i1 = ident();
					if (inputState.guessing == 0) {
						cls.setName(i1);
					}
				} else if ((LA(1) == LCURLY) && (_tokenSet_37.member(LA(2)))) {
					if (inputState.guessing == 0) {
						cls.setType(NamespaceTypes.MODULE);
					}
				} else if ((LA(1) == LCURLY) && (_tokenSet_37.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			match(LCURLY);
			namespaceScope2(cls.scope());
			match(RCURLY);
			if (inputState.guessing == 0) {
				sc.add(cls);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_35);
			} else {
				throw ex;
			}
		}
	}

	public final void namespaceScope2(
	  final NamespaceScope cr
	) throws RecognitionException, TokenStreamException {

		AccessNotation acs = null;

		try {      // for error handling
			docstrings(cr);
			{
				do {
					if ((_tokenSet_38.member(LA(1)))) {
						{
							switch (LA(1)) {
							case LITERAL_const:
							case LITERAL_var:
							case LITERAL_val: {
								varStmt2(cr);
								break;
							}
							case LITERAL_type: {
								typeAlias2(cr.typeAlias());
								break;
							}
							case LITERAL_access: {
								acs = accessNotation();
								if (inputState.guessing == 0) {
									cr.addAccess(acs);
								}
								break;
							}
							default:
								if ((LA(1) == IDENT || LA(1) == ANNOT) && (_tokenSet_15.member(LA(2)))) {
									functionDef2(cr.funcDef());
								} else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_26.member(LA(2)))) {
									programStatement2(cr);
								} else {
									throw new NoViableAltException(LT(1), getFilename());
								}
							}
						}
						opt_semi();
					} else {
						break;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case LITERAL_invariant: {
					invariantStatement(cr.invariantStatement());
					break;
				}
				case RCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final ImportStatement importStatement(
	  final OS_Element el
	) throws RecognitionException, TokenStreamException {
		ImportStatement pc;

		pc = null;
		ImportContext ctx = null;

		try {      // for error handling
			switch (LA(1)) {
			case LITERAL_from: {
				match(LITERAL_from);
				if (inputState.guessing == 0) {
					pc  = new RootedImportStatement(el);
					ctx = new ImportContext(cur, pc);
					pc.setContext(ctx);
					cur = ctx;
				}
				xy = qualident();
				match(LITERAL_import);
				qualidentList(((RootedImportStatement) pc).importList());
				if (inputState.guessing == 0) {
					((RootedImportStatement) pc).importRoot(xy);
				}
				opt_semi();
				break;
			}
			case LITERAL_import: {
				match(LITERAL_import);
				{
					boolean synPredMatched78 = false;
					if (((LA(1) == IDENT) && (LA(2) == BECOMES))) {
						final int _m78 = mark();
						synPredMatched78 = true;
						inputState.guessing++;
						try {
							{
								match(IDENT);
								match(BECOMES);
							}
						} catch (final RecognitionException pe) {
							synPredMatched78 = false;
						}
						rewind(_m78);
						inputState.guessing--;
					}
					if (synPredMatched78) {
						if (inputState.guessing == 0) {
							pc  = new AssigningImportStatement(el);
							ctx = new ImportContext(cur, pc);
							pc.setContext(ctx);
							cur = ctx;
						}
						importPart1((AssigningImportStatement) pc);
						{
							do {
								if ((LA(1) == COMMA)) {
									match(COMMA);
									importPart1((AssigningImportStatement) pc);
								} else {
									break;
								}

							} while (true);
						}
					} else {
						boolean synPredMatched82 = false;
						if (((LA(1) == IDENT) && (LA(2) == DOT || LA(2) == LCURLY))) {
							final int _m82 = mark();
							synPredMatched82 = true;
							inputState.guessing++;
							try {
								{
									qualident();
									match(LCURLY);
								}
							} catch (final RecognitionException pe) {
								synPredMatched82 = false;
							}
							rewind(_m82);
							inputState.guessing--;
						}
						if (synPredMatched82) {
							if (inputState.guessing == 0) {
								pc  = new QualifiedImportStatement(el);
								ctx = new ImportContext(cur, pc);
								pc.setContext(ctx);
								cur = ctx;
							}
							importPart2((QualifiedImportStatement) pc);
							{
								do {
									if ((LA(1) == COMMA)) {
										match(COMMA);
										importPart2((QualifiedImportStatement) pc);
									} else {
										break;
									}

								} while (true);
							}
						} else if ((LA(1) == IDENT) && (_tokenSet_39.member(LA(2)))) {
							if (inputState.guessing == 0) {
								pc  = new NormalImportStatement(el);
								ctx = new ImportContext(cur, pc);
								pc.setContext(ctx);
								cur = ctx;
							}
							importPart3((NormalImportStatement) pc);
							{
								do {
									if ((LA(1) == COMMA)) {
										match(COMMA);
										importPart3((NormalImportStatement) pc);
									} else {
										break;
									}

								} while (true);
							}
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}
					}
				}
				opt_semi();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_5);
			} else {
				throw ex;
			}
		}
		return pc;
	}

	public final void qualidentList(
	  final QualidentList qal
	) throws RecognitionException, TokenStreamException {

		Qualident qid;

		try {      // for error handling
			qid = qualident();
			if (inputState.guessing == 0) {
				qal.add(qid);
			}
			{
				do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						qid = qualident();
						if (inputState.guessing == 0) {
							qal.add(qid);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_5);
			} else {
				throw ex;
			}
		}
	}

	public final void importPart1(
	  final AssigningImportStatement cr
	) throws RecognitionException, TokenStreamException {

		IdentExpression i1 = null;
		Qualident       q1 = null;

		try {      // for error handling
			i1 = ident();
			match(BECOMES);
			q1 = qualident();
			if (inputState.guessing == 0) {
				cr.addAssigningPart(i1, q1);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_40);
			} else {
				throw ex;
			}
		}
	}

	public final void importPart2(
	  final QualifiedImportStatement cr
	) throws RecognitionException, TokenStreamException {

		final Qualident q3;
		IdentList       il = new IdentList();

		try {      // for error handling
			q3 = qualident();
			match(LCURLY);
			il = identList2();
			if (inputState.guessing == 0) {
				cr.addSelectivePart(q3, il);
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_40);
			} else {
				throw ex;
			}
		}
	}

	public final void importPart3(
	  final NormalImportStatement cr
	) throws RecognitionException, TokenStreamException {

		final Qualident q2;

		try {      // for error handling
			q2 = qualident();
			if (inputState.guessing == 0) {
				cr.addNormalPart(q2);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_40);
			} else {
				throw ex;
			}
		}
	}

	public final void importStatement2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final ImportStatementBuilder ib  = new ImportStatementBuilder();
		final ImportStatement        pc  = null;
		QualidentList                qil = null;

		try {      // for error handling
			switch (LA(1)) {
			case LITERAL_from: {
				match(LITERAL_from);
				xy = qualident();
				match(LITERAL_import);
				qil = qualidentList2();
				if (inputState.guessing == 0) {
					ib.rooted(xy, qil);
				}
				opt_semi();
				break;
			}
			case LITERAL_import: {
				match(LITERAL_import);
				{
					boolean synPredMatched90 = false;
					if (((LA(1) == IDENT) && (LA(2) == BECOMES))) {
						final int _m90 = mark();
						synPredMatched90 = true;
						inputState.guessing++;
						try {
							{
								match(IDENT);
								match(BECOMES);
							}
						} catch (final RecognitionException pe) {
							synPredMatched90 = false;
						}
						rewind(_m90);
						inputState.guessing--;
					}
					if (synPredMatched90) {
						importPart1_(ib);
						{
							do {
								if ((LA(1) == COMMA)) {
									match(COMMA);
									importPart1_(ib);
								} else {
									break;
								}

							} while (true);
						}
					} else {
						boolean synPredMatched94 = false;
						if (((_tokenSet_35.member(LA(1))) && (_tokenSet_41.member(LA(2))))) {
							final int _m94 = mark();
							synPredMatched94 = true;
							inputState.guessing++;
							try {
								{
									qualident();
									match(LCURLY);
								}
							} catch (final RecognitionException pe) {
								synPredMatched94 = false;
							}
							rewind(_m94);
							inputState.guessing--;
						}
						if (synPredMatched94) {
						} else if ((LA(1) == IDENT) && (LA(2) == DOT || LA(2) == LCURLY)) {
							importPart2_(ib);
							{
								do {
									if ((LA(1) == COMMA)) {
										match(COMMA);
										importPart2_(ib);
									} else {
										break;
									}

								} while (true);
							}
						} else if ((LA(1) == IDENT) && (_tokenSet_42.member(LA(2)))) {
							importPart3_(ib);
							{
								do {
									if ((LA(1) == COMMA)) {
										match(COMMA);
										importPart3_(ib);
									} else {
										break;
									}

								} while (true);
							}
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}
					}
				}
				opt_semi();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_35);
			} else {
				throw ex;
			}
		}
	}

	public final QualidentList qualidentList2() throws RecognitionException, TokenStreamException {
		final QualidentList qal;

		Qualident qid;
		qal = new QualidentList();

		try {      // for error handling
			qid = qualident();
			if (inputState.guessing == 0) {
				qal.add(qid);
			}
			{
				do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						qid = qualident();
						if (inputState.guessing == 0) {
							qal.add(qid);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_35);
			} else {
				throw ex;
			}
		}
		return qal;
	}

	public final void importPart1_(
	  final ImportStatementBuilder cr
	) throws RecognitionException, TokenStreamException {

		IdentExpression i1 = null;
		Qualident       q1 = null;

		try {      // for error handling
			i1 = ident();
			match(BECOMES);
			q1 = qualident();
			if (inputState.guessing == 0) {
				cr.addAssigningPart(i1, q1);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_43);
			} else {
				throw ex;
			}
		}
	}

	public final void importPart2_(
	  final ImportStatementBuilder cr
	) throws RecognitionException, TokenStreamException {

		final Qualident q3;
		IdentList       il = new IdentList();

		try {      // for error handling
			q3 = qualident();
			match(LCURLY);
			il = identList2();
			if (inputState.guessing == 0) {
				cr.addSelectivePart(q3, il);
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_43);
			} else {
				throw ex;
			}
		}
	}

	public final void importPart3_(
	  final ImportStatementBuilder cr
	) throws RecognitionException, TokenStreamException {

		final Qualident q2;

		try {      // for error handling
			q2 = qualident();
			if (inputState.guessing == 0) {
				cr.addNormalPart(q2);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_43);
			} else {
				throw ex;
			}
		}
	}

	public final IdentList identList2() throws RecognitionException, TokenStreamException {
		final IdentList ail;

		IdentExpression s = null;
		ail = new IdentList();

		try {      // for error handling
			s = ident();
			if (inputState.guessing == 0) {
				ail.push(s);
			}
			{
				do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						s = ident();
						if (inputState.guessing == 0) {
							ail.push(s);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
		return ail;
	}

	public final TypeName inhTypeName() throws RecognitionException, TokenStreamException {
		TypeName tn;

		tn = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_typeof: {
					tn = typeOfTypeName2();
					break;
				}
				case IDENT:
				case LITERAL_const:
				case LITERAL_in:
				case LITERAL_out:
				case LITERAL_ref: {
					tn = normalTypeName2();
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				tn.setContext(cur);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_44);
			} else {
				throw ex;
			}
		}
		return tn;
	}

	public final FormalArgList opfal() throws RecognitionException, TokenStreamException {
		FormalArgList fal;

		fal = null;

		try {      // for error handling
			match(LPAREN);
			fal = formalArgList();
			match(RPAREN);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_45);
			} else {
				throw ex;
			}
		}
		return fal;
	}

	public final Scope3 scope3(
	  final OS_Element parent
	) throws RecognitionException, TokenStreamException {
		final Scope3 sc;

		sc = new Scope3(parent);
		ClassStatement cls = null;

		try {      // for error handling
			match(LCURLY);
			docstrings(sc);
			{
				do {
					if ((_tokenSet_46.member(LA(1)))) {
						{
							switch (LA(1)) {
							case LITERAL_class: {
								cls = classStatement(sc.getParent(), cur, null/*annotations*/);
								if (inputState.guessing == 0) {
									sc.add(cls);
								}
								break;
							}
							case LITERAL_continue: {
								match(LITERAL_continue);
								break;
							}
							case LITERAL_break: {
								match(LITERAL_break);
								break;
							}
							case LITERAL_return: {
								match(LITERAL_return);
								{
									boolean synPredMatched140 = false;
									if (((_tokenSet_19.member(LA(1))) && (_tokenSet_47.member(LA(2))))) {
										final int _m140 = mark();
										synPredMatched140 = true;
										inputState.guessing++;
										try {
											{
												expression();
											}
										} catch (final RecognitionException pe) {
											synPredMatched140 = false;
										}
										rewind(_m140);
										inputState.guessing--;
									}
									if (synPredMatched140) {
										{
											expr = expression();
										}
									} else if ((_tokenSet_48.member(LA(1))) && (_tokenSet_49.member(LA(2)))) {
									} else {
										throw new NoViableAltException(LT(1), getFilename());
									}

								}
								break;
							}
							case LITERAL_with: {
								withStatement(sc.getParent());
								break;
							}
							default:
								if ((_tokenSet_50.member(LA(1))) && (_tokenSet_51.member(LA(2)))) {
									statement(sc.statementClosure(), sc.getParent());
								} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_47.member(LA(2)))) {
									expr = expression();
									if (inputState.guessing == 0) {
										sc.statementWrapper(expr);
									}
								} else if ((LA(1) == LCURLY) && (_tokenSet_52.member(LA(2)))) {
									syntacticBlockScope(sc.getParent());
								} else {
									throw new NoViableAltException(LT(1), getFilename());
								}
							}
						}
						opt_semi();
					} else {
						break;
					}

				} while (true);
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_53);
			} else {
				throw ex;
			}
		}
		return sc;
	}

	public final void constructor_scope2(
	  final ConstructorDefScope sc
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			match(LCURLY);
			docstrings(sc);
			{
				do {
					if ((_tokenSet_54.member(LA(1)))) {
						{
							switch (LA(1)) {
							case LITERAL_class:
							case ANNOT: {
								classStatement2(sc);
								break;
							}
							case LITERAL_continue: {
								match(LITERAL_continue);
								if (inputState.guessing == 0) {
									sc.continue_statement();
								}
								break;
							}
							case LITERAL_break: {
								match(LITERAL_break);
								if (inputState.guessing == 0) {
									sc.break_statement();
								}
								break;
							}
							case LITERAL_return: {
								match(LITERAL_return);
								{
									boolean synPredMatched156 = false;
									if (((_tokenSet_19.member(LA(1))) && (_tokenSet_55.member(LA(2))))) {
										final int _m156 = mark();
										synPredMatched156 = true;
										inputState.guessing++;
										try {
											{
												expression();
											}
										} catch (final RecognitionException pe) {
											synPredMatched156 = false;
										}
										rewind(_m156);
										inputState.guessing--;
									}
									if (synPredMatched156) {
										{
											expr = expression();
										}
										if (inputState.guessing == 0) {
											sc.return_expression(expr);
										}
									} else if ((_tokenSet_56.member(LA(1))) && (_tokenSet_57.member(LA(2)))) {
										if (inputState.guessing == 0) {
											sc.return_expression(null);
										}
									} else {
										throw new NoViableAltException(LT(1), getFilename());
									}

								}
								break;
							}
							case LITERAL_with: {
								withStatement2(sc);
								break;
							}
							default:
								if ((_tokenSet_50.member(LA(1))) && (_tokenSet_58.member(LA(2)))) {
									statement2(sc);
								} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_55.member(LA(2)))) {
									expr = expression();
									if (inputState.guessing == 0) {
										sc.statementWrapper(expr);
									}
								} else if ((LA(1) == LCURLY) && (_tokenSet_59.member(LA(2)))) {
									syntacticBlockScope2(sc);
								} else {
									throw new NoViableAltException(LT(1), getFilename());
								}
							}
						}
						opt_semi();
					} else {
						break;
					}

				} while (true);
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_32);
			} else {
				throw ex;
			}
		}
	}

	public final void scope2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			match(LCURLY);
			docstrings(sc);
			{
				do {
					if ((_tokenSet_54.member(LA(1)))) {
						{
							switch (LA(1)) {
							case LITERAL_class:
							case ANNOT: {
								classStatement2(sc);
								break;
							}
							case LITERAL_continue: {
								match(LITERAL_continue);
								if (inputState.guessing == 0) {
									sc.continue_statement();
								}
								break;
							}
							case LITERAL_break: {
								match(LITERAL_break);
								if (inputState.guessing == 0) {
									sc.break_statement();
								}
								break;
							}
							case LITERAL_return: {
								match(LITERAL_return);
								{
									boolean synPredMatched148 = false;
									if (((_tokenSet_19.member(LA(1))) && (_tokenSet_55.member(LA(2))))) {
										final int _m148 = mark();
										synPredMatched148 = true;
										inputState.guessing++;
										try {
											{
												expression();
											}
										} catch (final RecognitionException pe) {
											synPredMatched148 = false;
										}
										rewind(_m148);
										inputState.guessing--;
									}
									if (synPredMatched148) {
										{
											expr = expression();
										}
										if (inputState.guessing == 0) {
											sc.return_expression(expr);
										}
									} else if ((_tokenSet_56.member(LA(1))) && (_tokenSet_60.member(LA(2)))) {
										if (inputState.guessing == 0) {
											sc.return_expression(null);
										}
									} else {
										throw new NoViableAltException(LT(1), getFilename());
									}

								}
								break;
							}
							case LITERAL_with: {
								withStatement2(sc);
								break;
							}
							default:
								if ((_tokenSet_50.member(LA(1))) && (_tokenSet_58.member(LA(2)))) {
									statement2(sc);
								} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_55.member(LA(2)))) {
									expr = expression();
									if (inputState.guessing == 0) {
										sc.statementWrapper(expr);
									}
								} else if ((LA(1) == LCURLY) && (_tokenSet_59.member(LA(2)))) {
									syntacticBlockScope2(sc);
								} else {
									throw new NoViableAltException(LT(1), getFilename());
								}
							}
						}
						opt_semi();
					} else {
						break;
					}

				} while (true);
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_61);
			} else {
				throw ex;
			}
		}
	}

	public final void statement(
	  final StatementClosure cr, final OS_Element aParent
	) throws RecognitionException, TokenStreamException {

		final Qualident      q = null;
		final ExpressionList o = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure: {
					expr = assignmentExpression();
					if (inputState.guessing == 0) {
						cr.statementWrapper(expr);
					}
					break;
				}
				case LITERAL_if: {
					ifConditional(cr.ifConditional(aParent, cur));
					break;
				}
				case LITERAL_match: {
					matchConditional(cr.matchConditional(cur), aParent);
					break;
				}
				case LITERAL_case: {
					caseConditional(cr.caseConditional(cur));
					break;
				}
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val: {
					varStmt(cr, aParent);
					break;
				}
				case LITERAL_while:
				case LITERAL_do: {
					whileLoop(cr);
					break;
				}
				case LITERAL_iterate: {
					frobeIteration(cr);
					break;
				}
				case LITERAL_construct: {
					constructExpression(cr);
					break;
				}
				case LITERAL_yield: {
					match(LITERAL_yield);
					expr = expression();
					if (inputState.guessing == 0) {
						cr.yield(expr);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			opt_semi();
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final IExpression expression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;

		try {      // for error handling
			ee = assignmentExpression();
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final void withStatement(
	  final OS_Element aParent
	) throws RecognitionException, TokenStreamException {

		final WithStatement ws  = new WithStatement(aParent);
		WithContext         ctx = null;

		try {      // for error handling
			match(LITERAL_with);
			varStmt_i(ws.nextVarStmt());
			{
				match(COMMA);
				varStmt_i(ws.nextVarStmt());
			}
			if (inputState.guessing == 0) {
				ctx = new WithContext(ws, cur);
				ws.setContext(ctx);
				cur = ctx;
			}
			sco = scope3(ws);
			if (inputState.guessing == 0) {
				ws.scope(sco);
			}
			if (inputState.guessing == 0) {
				ws.postConstruct();
				cur = cur.getParent();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final void syntacticBlockScope(
	  final OS_Element aParent
	) throws RecognitionException, TokenStreamException {

		final SyntacticBlock  sb  = new SyntacticBlock(aParent);
		SyntacticBlockContext ctx = null;

		try {      // for error handling
			if (inputState.guessing == 0) {
				ctx = new SyntacticBlockContext(sb, cur);
				sb.setContext(ctx);
				cur = ctx;
			}
			sco = scope3(sb);
			if (inputState.guessing == 0) {
				sb.scope(sco);
			}
			if (inputState.guessing == 0) {
				sb.postConstruct();
				cur = cur.getParent();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final void statement2(
	  final BaseScope cr
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			{
				switch (LA(1)) {
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure: {
					expr = assignmentExpression();
					if (inputState.guessing == 0) {
						cr.statementWrapper(expr);
					}
					break;
				}
				case LITERAL_if: {
					ifConditional2(cr);
					break;
				}
				case LITERAL_match: {
					matchConditional2(cr);
					break;
				}
				case LITERAL_case: {
					caseConditional2(cr);
					break;
				}
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val: {
					varStmt2(cr);
					break;
				}
				case LITERAL_while:
				case LITERAL_do: {
					whileLoop2(cr);
					break;
				}
				case LITERAL_iterate: {
					frobeIteration2(cr);
					break;
				}
				case LITERAL_construct: {
					constructExpression2(cr);
					break;
				}
				case LITERAL_yield: {
					yieldExpression(cr);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			opt_semi();
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_62);
			} else {
				throw ex;
			}
		}
	}

	public final void withStatement2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final WithStatementBuilder    ws   = new WithStatementBuilder();
		final VariableSequenceBuilder vsqb = ws.sb();

		try {      // for error handling
			match(LITERAL_with);
			varStmt_i2(vsqb);
			{
				if (inputState.guessing == 0) {
					vsqb.next();
				}
				match(COMMA);
				varStmt_i2(vsqb);
			}
			scope2(ws.scope());
			if (inputState.guessing == 0) {
				sc.add(ws);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_56);
			} else {
				throw ex;
			}
		}
	}

	public final void syntacticBlockScope2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final SyntacticBlockBuilder sbb = new SyntacticBlockBuilder();

		try {      // for error handling
			scope2(sbb.scope());
			if (inputState.guessing == 0) {
				sc.add(sbb);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_56);
			} else {
				throw ex;
			}
		}
	}

	public final void varStmt_i(
	  final VariableStatement vs
	) throws RecognitionException, TokenStreamException {

		TypeName        tn = null;
		IdentExpression i  = null;

		try {      // for error handling
			i = ident();
			if (inputState.guessing == 0) {
				vs.setName(i);
			}
			{
				switch (LA(1)) {
				case TOK_COLON: {
					match(TOK_COLON);
					tn = typeName2();
					if (inputState.guessing == 0) {
						vs.setTypeName(tn);
					}
					break;
				}
				case LCURLY:
				case BECOMES:
				case COMMA: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case BECOMES: {
					match(BECOMES);
					expr = expression();
					if (inputState.guessing == 0) {
						vs.initial(expr);
					}
					break;
				}
				case LCURLY:
				case COMMA: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_63);
			} else {
				throw ex;
			}
		}
	}

	public final void varStmt_i2(
	  final VariableSequenceBuilder vsb
	) throws RecognitionException, TokenStreamException {

		final TypeName  tn = null;
		IdentExpression i  = null;

		try {      // for error handling
			i = ident();
			if (inputState.guessing == 0) {
				vsb.setName(i);
			}
			{
				switch (LA(1)) {
				case BECOMES: {
					match(BECOMES);
					expr = expression();
					if (inputState.guessing == 0) {
						vsb.setInitial(expr);
					}
					break;
				}
				case IDENT:
				case TOK_COLON:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LITERAL_class:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case RCURLY:
				case LITERAL_type:
				case ANNOT:
				case LITERAL_namespace:
				case LITERAL_from:
				case LITERAL_import:
				case COMMA:
				case LITERAL_constructor:
				case LITERAL_ctor:
				case LITERAL_destructor:
				case LITERAL_dtor:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_with:
				case LITERAL_post:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_alias:
				case LITERAL_yield:
				case LITERAL_construct:
				case SEMI:
				case LITERAL_invariant:
				case LITERAL_access:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_if:
				case LITERAL_match:
				case LITERAL_case:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_iterate:
				case LITERAL_prop:
				case LITERAL_property: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_64);
			} else {
				throw ex;
			}
		}
	}

	public final Scope3 functionScope(
	  final FunctionDef parent
	) throws RecognitionException, TokenStreamException {
		final Scope3 sc;

		sc = new Scope3(parent);
		ClassStatement cls = null;

		try {      // for error handling
			match(LCURLY);
			docstrings(sc);
			{
				switch (LA(1)) {
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LITERAL_class:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case RCURLY:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_yield:
				case LITERAL_construct:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_if:
				case LITERAL_match:
				case LITERAL_case:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_iterate: {
					{
						do {
							if ((_tokenSet_65.member(LA(1)))) {
								{
									switch (LA(1)) {
									case LITERAL_class: {
										cls = classStatement(sc.getParent(), cur, null/*annotations*/);
										if (inputState.guessing == 0) {
											sc.add(cls);
										}
										break;
									}
									case LITERAL_continue: {
										match(LITERAL_continue);
										break;
									}
									case LITERAL_break: {
										match(LITERAL_break);
										break;
									}
									case LITERAL_return: {
										match(LITERAL_return);
										{
											boolean synPredMatched171 = false;
											if (((_tokenSet_19.member(LA(1))) && (_tokenSet_66.member(LA(2))))) {
												final int _m171 = mark();
												synPredMatched171 = true;
												inputState.guessing++;
												try {
													{
														expression();
													}
												} catch (final RecognitionException pe) {
													synPredMatched171 = false;
												}
												rewind(_m171);
												inputState.guessing--;
											}
											if (synPredMatched171) {
												{
													expr = expression();
												}
											} else if ((_tokenSet_67.member(LA(1))) && (_tokenSet_68.member(LA(2)))) {
											} else {
												throw new NoViableAltException(LT(1), getFilename());
											}

										}
										break;
									}
									default:
										if ((_tokenSet_50.member(LA(1))) && (_tokenSet_69.member(LA(2)))) {
											statement(sc.statementClosure(), sc.getParent());
										} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_66.member(LA(2)))) {
											expr = expression();
											if (inputState.guessing == 0) {
												sc.statementWrapper(expr);
											}
										} else {
											throw new NoViableAltException(LT(1), getFilename());
										}
									}
								}
								opt_semi();
							} else {
								break;
							}

						} while (true);
					}
					break;
				}
				case LITERAL_abstract: {
					match(LITERAL_abstract);
					opt_semi();
					if (inputState.guessing == 0) {
						parent.setAbstract(true);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_30);
			} else {
				throw ex;
			}
		}
		return sc;
	}

	public final void functionScope2(
	  final FunctionDefScope sc
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			match(LCURLY);
			docstrings(sc);
			{
				switch (LA(1)) {
				case LITERAL_pre: {
					preConditionSegment(sc);
					break;
				}
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LITERAL_class:
				case LITERAL_abstract:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case RCURLY:
				case ANNOT:
				case LITERAL_return:
				case LITERAL_post:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_yield:
				case LITERAL_construct:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_if:
				case LITERAL_match:
				case LITERAL_case:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_iterate: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LITERAL_class:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case RCURLY:
				case ANNOT:
				case LITERAL_return:
				case LITERAL_post:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_yield:
				case LITERAL_construct:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_if:
				case LITERAL_match:
				case LITERAL_case:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_iterate: {
					{
						do {
							if ((_tokenSet_70.member(LA(1)))) {
								{
									switch (LA(1)) {
									case LITERAL_class:
									case ANNOT: {
										classStatement2(sc);
										break;
									}
									case LITERAL_return: {
										returnExpressionFunctionDefScope(sc);
										break;
									}
									default:
										if ((_tokenSet_50.member(LA(1))) && (_tokenSet_71.member(LA(2)))) {
											statement2(sc);
										} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_72.member(LA(2)))) {
											expr = expression();
											if (inputState.guessing == 0) {
												sc.statementWrapper(expr);
											}
										} else {
											throw new NoViableAltException(LT(1), getFilename());
										}
									}
								}
								opt_semi();
							} else {
								break;
							}

						} while (true);
					}
					break;
				}
				case LITERAL_abstract: {
					match(LITERAL_abstract);
					opt_semi();
					if (inputState.guessing == 0) {
						sc.setAbstract();
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case LITERAL_post: {
					postConditionSegment(sc);
					break;
				}
				case RCURLY: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_35);
			} else {
				throw ex;
			}
		}
	}

	public final void preConditionSegment(
	  final FunctionDefScope sc
	) throws RecognitionException, TokenStreamException {

		Precondition p = null;

		try {      // for error handling
			match(LITERAL_pre);
			match(LCURLY);
			{
				do {
					if ((_tokenSet_19.member(LA(1)))) {
						p = precondition();
						if (inputState.guessing == 0) {
							sc.addPreCondition(p);
						}
					} else {
						break;
					}

				} while (true);
			}
			match(RCURLY);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_73);
			} else {
				throw ex;
			}
		}
	}

	public final void returnExpressionFunctionDefScope(
	  final FunctionDefScope sc
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			match(LITERAL_return);
			{
				boolean synPredMatched184 = false;
				if (((_tokenSet_19.member(LA(1))) && (_tokenSet_72.member(LA(2))))) {
					final int _m184 = mark();
					synPredMatched184 = true;
					inputState.guessing++;
					try {
						{
							expression();
						}
					} catch (final RecognitionException pe) {
						synPredMatched184 = false;
					}
					rewind(_m184);
					inputState.guessing--;
				}
				if (synPredMatched184) {
					{
						expr = expression();
					}
					if (inputState.guessing == 0) {
						sc.return_expression(expr);
					}
				} else if ((_tokenSet_74.member(LA(1))) && (_tokenSet_75.member(LA(2)))) {
					if (inputState.guessing == 0) {
						sc.return_expression(null);
					}
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_74);
			} else {
				throw ex;
			}
		}
	}

	public final void postConditionSegment(
	  final FunctionDefScope sc
	) throws RecognitionException, TokenStreamException {

		Postcondition po = null;

		try {      // for error handling
			match(LITERAL_post);
			{
				if ((LA(1) == LCURLY) && (_tokenSet_76.member(LA(2)))) {
					match(LCURLY);
					{
						do {
							if ((_tokenSet_19.member(LA(1)))) {
								po = postcondition();
								if (inputState.guessing == 0) {
									sc.addPostCondition(po);
								}
							} else {
								break;
							}

						} while (true);
					}
					match(RCURLY);
				} else if ((_tokenSet_76.member(LA(1))) && (_tokenSet_77.member(LA(2)))) {
					{
						do {
							if ((_tokenSet_19.member(LA(1)))) {
								po = postcondition();
								if (inputState.guessing == 0) {
									sc.addPostCondition(po);
								}
							} else {
								break;
							}

						} while (true);
					}
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_18);
			} else {
				throw ex;
			}
		}
	}

	public final Precondition precondition() throws RecognitionException, TokenStreamException {
		final Precondition prec;

		prec = new Precondition();
		IdentExpression id = null;

		try {      // for error handling
			{
				if ((LA(1) == IDENT) && (LA(2) == TOK_COLON)) {
					id = ident();
					match(TOK_COLON);
					if (inputState.guessing == 0) {
						prec.id(id);
					}
				} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_20.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			expr = expression();
			if (inputState.guessing == 0) {
				prec.expr(expr);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_76);
			} else {
				throw ex;
			}
		}
		return prec;
	}

	public final Postcondition postcondition() throws RecognitionException, TokenStreamException {
		final Postcondition postc;

		postc = new Postcondition();
		IdentExpression id = null;

		try {      // for error handling
			{
				if ((LA(1) == IDENT) && (LA(2) == TOK_COLON)) {
					id = ident();
					match(TOK_COLON);
					if (inputState.guessing == 0) {
						postc.id(id);
					}
				} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_20.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			expr = expression();
			if (inputState.guessing == 0) {
				postc.expr(expr);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_76);
			} else {
				throw ex;
			}
		}
		return postc;
	}

	public final TypeName typeName2() throws RecognitionException, TokenStreamException {
		TypeName cr;

		cr = null;

		try {      // for error handling
			switch (LA(1)) {
			case LITERAL_generic:
			case QUESTION: {
				cr = genericTypeName2();
				break;
			}
			case LITERAL_typeof: {
				cr = typeOfTypeName2();
				break;
			}
			case IDENT:
			case LITERAL_const:
			case LITERAL_in:
			case LITERAL_out:
			case LITERAL_ref: {
				cr = normalTypeName2();
				break;
			}
			case LITERAL_function:
			case LITERAL_procedure:
			case LITERAL_func:
			case LITERAL_proc: {
				cr = functionTypeName2();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return cr;
	}

	public final AliasStatement aliasStatement(
	  final OS_Element cont
	) throws RecognitionException, TokenStreamException {
		final AliasStatement pc;

		IdentExpression i1 = null;
		pc = new AliasStatement(cont);

		try {      // for error handling
			match(LITERAL_alias);
			i1 = ident();
			if (inputState.guessing == 0) {
				pc.setName(i1);
			}
			match(BECOMES);
			xy = qualident();
			if (inputState.guessing == 0) {
				pc.setExpression(xy);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_5);
			} else {
				throw ex;
			}
		}
		return pc;
	}

	public final void aliasStatement2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final AliasStatementBuilder pc = new AliasStatementBuilder();
		IdentExpression             i1 = null;

		try {      // for error handling
			match(LITERAL_alias);
			i1 = ident();
			if (inputState.guessing == 0) {
				pc.setName(i1);
			}
			match(BECOMES);
			xy = qualident();
			if (inputState.guessing == 0) {
				pc.setExpression(xy);
			}
			if (inputState.guessing == 0) {
				sc.add(pc);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_35);
			} else {
				throw ex;
			}
		}
	}

	public final void varStmt_i3(
	  final VariableStatement vs
	) throws RecognitionException, TokenStreamException {

		IdentExpression i = null;

		try {      // for error handling
			i = ident();
			if (inputState.guessing == 0) {
				vs.setName(i);
			}
			{
				switch (LA(1)) {
				case BECOMES: {
					match(BECOMES);
					expr = expression();
					if (inputState.guessing == 0) {
						vs.initial(expr);
					}
					break;
				}
				case IDENT:
				case TOK_COLON:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LITERAL_class:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case RCURLY:
				case LITERAL_type:
				case ANNOT:
				case LITERAL_namespace:
				case LITERAL_from:
				case LITERAL_import:
				case COMMA:
				case LITERAL_constructor:
				case LITERAL_ctor:
				case LITERAL_destructor:
				case LITERAL_dtor:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_with:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_alias:
				case LITERAL_yield:
				case LITERAL_construct:
				case SEMI:
				case LITERAL_invariant:
				case LITERAL_access:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_if:
				case LITERAL_match:
				case LITERAL_case:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_iterate:
				case LITERAL_def:
				case LITERAL_prop:
				case LITERAL_property: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_78);
			} else {
				throw ex;
			}
		}
	}

	public final FormalArgList formalArgList() throws RecognitionException, TokenStreamException {
		final FormalArgList fal;

		fal = new FormalArgList();

		try {      // for error handling
			formalArgList_(fal);
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_79);
			} else {
				throw ex;
			}
		}
		return fal;
	}

	public final void formalArgList_(
	  final FormalArgList fal
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			{
				switch (LA(1)) {
				case IDENT:
				case LITERAL_const:
				case LITERAL_in:
				case LITERAL_out:
				case LITERAL_ref: {
					formalArgListItem_priv(fal.next());
					{
						do {
							if ((LA(1) == COMMA)) {
								match(COMMA);
								formalArgListItem_priv(fal.next());
							} else {
								break;
							}

						} while (true);
					}
					break;
				}
				case RPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_79);
			} else {
				throw ex;
			}
		}
	}

	public final IExpression assignmentExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		final IExpression e  = null;
		final IExpression e2;
		ExpressionKind    ek = null;

		try {      // for error handling
			ee = conditionalExpression();
			{
				if ((_tokenSet_80.member(LA(1))) && (_tokenSet_19.member(LA(2)))) {
					{
						switch (LA(1)) {
						case BECOMES: {
							match(BECOMES);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.ASSIGNMENT);
							}
							break;
						}
						case PLUS_ASSIGN: {
							match(PLUS_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_PLUS);
							}
							break;
						}
						case MINUS_ASSIGN: {
							match(MINUS_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_MINUS);
							}
							break;
						}
						case STAR_ASSIGN: {
							match(STAR_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_MULT);
							}
							break;
						}
						case DIV_ASSIGN: {
							match(DIV_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_DIV);
							}
							break;
						}
						case MOD_ASSIGN: {
							match(MOD_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_MOD);
							}
							break;
						}
						case SR_ASSIGN: {
							match(SR_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_SR);
							}
							break;
						}
						case BSR_ASSIGN: {
							match(BSR_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_BSR);
							}
							break;
						}
						case SL_ASSIGN: {
							match(SL_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_SL);
							}
							break;
						}
						case BAND_ASSIGN: {
							match(BAND_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_BAND);
							}
							break;
						}
						case BXOR_ASSIGN: {
							match(BXOR_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_BXOR);
							}
							break;
						}
						case BOR_ASSIGN: {
							match(BOR_ASSIGN);
							if (inputState.guessing == 0) {
								ek = (ExpressionKind.AUG_BOR);
							}
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					e2 = assignmentExpression();
					if (inputState.guessing == 0) {
						ee = ExpressionBuilder.build(ee, ek, e2);
					}
				} else if ((_tokenSet_7.member(LA(1))) && (_tokenSet_81.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final void ifConditional(
	  final IfConditional ifex
	) throws RecognitionException, TokenStreamException {

		final IfConditionalContext ifc_top = null;
		final IfConditionalContext ifc     = null;
		IfConditional              else_   = null;

		try {      // for error handling
			match(LITERAL_if);
			expr = expression();
			if (inputState.guessing == 0) {
				ifex.expr(expr);
				cur = ifex.getContext();
			}
			sco = scope3(ifex);
			if (inputState.guessing == 0) {
				ifex.scope(sco);
			}
			if (inputState.guessing == 0) {
				cur = cur.getParent();
			}
			{
				do {
					boolean synPredMatched351 = false;
					if (((LA(1) == LITERAL_else || LA(1) == LITERAL_elseif) && (_tokenSet_82.member(LA(2))))) {
						final int _m351 = mark();
						synPredMatched351 = true;
						inputState.guessing++;
						try {
							{
								match(LITERAL_else);
								match(LITERAL_if);
							}
						} catch (final RecognitionException pe) {
							synPredMatched351 = false;
						}
						rewind(_m351);
						inputState.guessing--;
					}
					if (synPredMatched351) {
						elseif_part(ifex.elseif());
					} else {
						break;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case LITERAL_else: {
					match(LITERAL_else);
					if (inputState.guessing == 0) {
						else_ = ifex.else_();
						cur   = else_.getContext();
					}
					sco = scope3(else_);
					if (inputState.guessing == 0) {
						if (else_ != null) else_.scope(sco);
					}
					if (inputState.guessing == 0) {
						cur = cur.getParent();
					}
					break;
				}
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LITERAL_class:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case RCURLY:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_with:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_yield:
				case LITERAL_construct:
				case SEMI:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_if:
				case LITERAL_match:
				case LITERAL_case:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_iterate: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final void matchConditional(
	  final MatchConditional mc, final OS_Element aParent
	) throws RecognitionException, TokenStreamException {

		MatchConditional.MatchArm_TypeMatch    mcp1 = null;
		MatchConditional.MatchConditionalPart2 mcp2 = null;
		MatchConditional.MatchConditionalPart3 mcp3 = null;
		TypeName                               tn   = null;
		IdentExpression                        i1   = null;
		final MatchContext                     ctx  = null;

		try {      // for error handling
			match(LITERAL_match);
			expr = expression();
			if (inputState.guessing == 0) {
				/*mc.setParent(aParent);*/
				mc.expr(expr);
			}
			match(LCURLY);
			{
				int _cnt358 = 0;
				do {
					if ((LA(1) == IDENT) && (LA(2) == TOK_COLON)) {
						if (inputState.guessing == 0) {
							mcp1 = mc.typeMatch();
						}
						i1 = ident();
						if (inputState.guessing == 0) {
							mcp1.ident(i1);
						}
						match(TOK_COLON);
						tn = typeName2();
						if (inputState.guessing == 0) {
							mcp1.setTypeName(tn);
						}
						sco = scope3(mcp1);
						if (inputState.guessing == 0) {
							mcp1.scope(sco);
						}
					} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_83.member(LA(2)))) {
						if (inputState.guessing == 0) {
							mcp2 = mc.normal();
						}
						expr = expression();
						if (inputState.guessing == 0) {
							mcp2.expr(expr);
						}
						sco = scope3(mcp2);
						if (inputState.guessing == 0) {
							mcp2.scope(sco);
						}
					} else if ((LA(1) == LITERAL_val)) {
						if (inputState.guessing == 0) {
							mcp3 = mc.valNormal();
						}
						match(LITERAL_val);
						i1 = ident();
						if (inputState.guessing == 0) {
							mcp3.expr(i1);
						}
						sco = scope3(mcp3);
						if (inputState.guessing == 0) {
							mcp3.scope(sco);
						}
					} else {
						if (_cnt358 >= 1) {
							break;
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}
					}

					_cnt358++;
				} while (true);
			}
			match(RCURLY);
			if (inputState.guessing == 0) {
				mc.postConstruct();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final void caseConditional(
	  final CaseConditional mc
	) throws RecognitionException, TokenStreamException {

		final CaseContext ctx   = null;
		IExpression       expr1 = null;

		try {      // for error handling
			match(LITERAL_case);
			expr = expression();
			if (inputState.guessing == 0) {
				mc.expr(expr);
			}
			match(LCURLY);
			{
				do {
					if ((_tokenSet_19.member(LA(1)))) {
						expr1 = expression();
						sco   = scope3(mc);
						if (inputState.guessing == 0) {
							mc.scope(sco, expr1);
						}
					} else {
						break;
					}

				} while (true);
			}
			match(RCURLY);
			if (inputState.guessing == 0) {
				mc.postConstruct();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final void whileLoop(
	  final StatementClosure cr
	) throws RecognitionException, TokenStreamException {

		final Loop        loop = cr.loop();
		final LoopContext ctx;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_while: {
					match(LITERAL_while);
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.WHILE);
					}
					expr = expression();
					if (inputState.guessing == 0) {
						loop.expr(expr);
					}
					if (inputState.guessing == 0) {
						ctx = new LoopContext(cur, loop);
						loop.setContext(ctx);
						cur = ctx;
					}
					sco = scope3(loop);
					if (inputState.guessing == 0) {
						loop.scope(sco);
					}
					break;
				}
				case LITERAL_do: {
					match(LITERAL_do);
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.DO_WHILE);
					}
					if (inputState.guessing == 0) {
						ctx = new LoopContext(cur, loop);
						loop.setContext(ctx);
						cur = ctx;
					}
					sco = scope3(loop);
					if (inputState.guessing == 0) {
						loop.scope(sco);
					}
					match(LITERAL_while);
					expr = expression();
					if (inputState.guessing == 0) {
						loop.expr(expr);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final void frobeIteration(
	  final StatementClosure cr
	) throws RecognitionException, TokenStreamException {

		final Loop      loop = cr.loop();
		LoopContext     ctx  = null;
		IdentExpression i1   = null, i2 = null, i3 = null;

		try {      // for error handling
			match(LITERAL_iterate);
			if (inputState.guessing == 0) {
				ctx = new LoopContext(cur, loop);
				loop.setContext(ctx);
				cur = ctx;
			}
			{
				switch (LA(1)) {
				case LITERAL_from: {
					match(LITERAL_from);
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.FROM_TO_TYPE);
					}
					expr = expression();
					if (inputState.guessing == 0) {
						loop.frompart(expr);
					}
					match(LITERAL_to);
					expr = expression();
					if (inputState.guessing == 0) {
						loop.topart(expr);
					}
					{
						switch (LA(1)) {
						case LITERAL_with: {
							match(LITERAL_with);
							i1 = ident();
							if (inputState.guessing == 0) {
								loop.iterName(i1);
							}
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case LITERAL_to: {
					match(LITERAL_to);
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.TO_TYPE);
					}
					expr = expression();
					if (inputState.guessing == 0) {
						loop.topart(expr);
					}
					{
						switch (LA(1)) {
						case LITERAL_with: {
							match(LITERAL_with);
							i2 = ident();
							if (inputState.guessing == 0) {
								loop.iterName(i2);
							}
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure: {
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.EXPR_TYPE);
					}
					expr = expression();
					if (inputState.guessing == 0) {
						loop.topart(expr);
					}
					{
						switch (LA(1)) {
						case LITERAL_with: {
							match(LITERAL_with);
							i3 = ident();
							if (inputState.guessing == 0) {
								loop.iterName(i3);
							}
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			sco = scope3(loop);
			if (inputState.guessing == 0) {
				loop.scope(sco);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final void constructExpression(
	  final StatementClosure cr
	) throws RecognitionException, TokenStreamException {

		Qualident      q = null;
		ExpressionList o = null;

		try {      // for error handling
			match(LITERAL_construct);
			q = qualident();
			{
				if ((LA(1) == LPAREN) && (_tokenSet_84.member(LA(2)))) {
					match(LPAREN);
					{
						switch (LA(1)) {
						case IDENT:
						case STRING_LITERAL:
						case CHAR_LITERAL:
						case NUM_INT:
						case NUM_FLOAT:
						case LBRACK:
						case LPAREN:
						case LCURLY:
						case PLUS:
						case MINUS:
						case INC:
						case DEC:
						case BNOT:
						case LNOT:
						case LITERAL_true:
						case LITERAL_false:
						case LITERAL_this:
						case LITERAL_null:
						case LITERAL_function:
						case LITERAL_procedure: {
							o = expressionList();
							break;
						}
						case RPAREN: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(RPAREN);
				} else if ((_tokenSet_48.member(LA(1))) && (_tokenSet_49.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			if (inputState.guessing == 0) {
				cr.constructExpression(q, o);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_48);
			} else {
				throw ex;
			}
		}
	}

	public final void ifConditional2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final IfConditionalBuilder ifb = new IfConditionalBuilder();

		try {      // for error handling
			match(LITERAL_if);
			expr = expression();
			if (inputState.guessing == 0) {
				ifb.base_expr.expr(expr);
			}
			scope2(ifb.base_expr.scope());
			{
				do {
					boolean synPredMatched372 = false;
					if (((LA(1) == LITERAL_else || LA(1) == LITERAL_elseif) && (_tokenSet_82.member(LA(2))))) {
						final int _m372 = mark();
						synPredMatched372 = true;
						inputState.guessing++;
						try {
							{
								match(LITERAL_else);
								match(LITERAL_if);
							}
						} catch (final RecognitionException pe) {
							synPredMatched372 = false;
						}
						rewind(_m372);
						inputState.guessing--;
					}
					if (synPredMatched372) {
						elseif_part2(ifb.new_expr());
					} else {
						break;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case LITERAL_else: {
					match(LITERAL_else);
					scope2(ifb.else_part.scope());
					break;
				}
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LITERAL_class:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case RCURLY:
				case ANNOT:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_with:
				case LITERAL_post:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_yield:
				case LITERAL_construct:
				case SEMI:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_if:
				case LITERAL_match:
				case LITERAL_case:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_iterate: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				sc.add(ifb);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_62);
			} else {
				throw ex;
			}
		}
	}

	public final void matchConditional2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final MatchConditionalBuilder mc = new MatchConditionalBuilder();
		TypeName                      tn = null;
		IdentExpression               i1 = null;

		try {      // for error handling
			match(LITERAL_match);
			expr = expression();
			if (inputState.guessing == 0) {
				mc.expr(expr);
			}
			match(LCURLY);
			{
				int _cnt379 = 0;
				do {
					if ((LA(1) == IDENT) && (LA(2) == TOK_COLON)) {
						i1 = ident();
						match(TOK_COLON);
						tn = typeName2();
						scope2(mc.typeMatchscope(i1, tn));
					} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_83.member(LA(2)))) {
						expr = expression();
						scope2(mc.normalscope(expr));
					} else if ((LA(1) == LITERAL_val)) {
						match(LITERAL_val);
						i1 = ident();
						scope2(mc.valNormalscope(i1));
					} else {
						if (_cnt379 >= 1) {
							break;
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}
					}

					_cnt379++;
				} while (true);
			}
			match(RCURLY);
			if (inputState.guessing == 0) {
				sc.add(mc);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_62);
			} else {
				throw ex;
			}
		}
	}

	public final void caseConditional2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final CaseConditionalBuilder mc = new CaseConditionalBuilder();

		try {      // for error handling
			match(LITERAL_case);
			expr = expression();
			if (inputState.guessing == 0) {
				mc.expr(expr);
			}
			match(LCURLY);
			{
				do {
					if ((_tokenSet_19.member(LA(1)))) {
						expr = expression();
						scope2(mc.scope(expr));
					} else {
						break;
					}

				} while (true);
			}
			match(RCURLY);
			if (inputState.guessing == 0) {
				sc.add(mc);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_62);
			} else {
				throw ex;
			}
		}
	}

	public final void whileLoop2(
	  final BaseScope sc
	) throws RecognitionException, TokenStreamException {

		final LoopBuilder loop = new LoopBuilder();
		LoopContext       ctx;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_while: {
					match(LITERAL_while);
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.WHILE);
					}
					expr = expression();
					if (inputState.guessing == 0) {
						loop.expr(expr);
					}
					scope2(loop.scope());
					break;
				}
				case LITERAL_do: {
					match(LITERAL_do);
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.DO_WHILE);
					}
					scope2(loop.scope());
					match(LITERAL_while);
					expr = expression();
					if (inputState.guessing == 0) {
						loop.expr(expr);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				sc.add(loop);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_62);
			} else {
				throw ex;
			}
		}
	}

	public final void frobeIteration2(
	  final BaseScope cr
	) throws RecognitionException, TokenStreamException {

		final LoopBuilder loop = new LoopBuilder();/*LoopContext ctx=null;*/
		IdentExpression   i1   = null, i2 = null, i3 = null;

		try {      // for error handling
			match(LITERAL_iterate);
			{
				switch (LA(1)) {
				case LITERAL_from: {
					match(LITERAL_from);
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.FROM_TO_TYPE);
					}
					expr = expression();
					if (inputState.guessing == 0) {
						loop.frompart(expr);
					}
					match(LITERAL_to);
					expr = expression();
					if (inputState.guessing == 0) {
						loop.topart(expr);
					}
					{
						switch (LA(1)) {
						case LITERAL_with: {
							match(LITERAL_with);
							i1 = ident();
							if (inputState.guessing == 0) {
								loop.iterName(i1);
							}
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case LITERAL_to: {
					match(LITERAL_to);
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.TO_TYPE);
					}
					expr = expression();
					if (inputState.guessing == 0) {
						loop.topart(expr);
					}
					{
						switch (LA(1)) {
						case LITERAL_with: {
							match(LITERAL_with);
							i2 = ident();
							if (inputState.guessing == 0) {
								loop.iterName(i2);
							}
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case IDENT:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case LBRACK:
				case LPAREN:
				case LCURLY:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure: {
					if (inputState.guessing == 0) {
						loop.type(LoopTypes.EXPR_TYPE);
					}
					expr = expression();
					if (inputState.guessing == 0) {
						loop.topart(expr);
					}
					{
						switch (LA(1)) {
						case LITERAL_with: {
							match(LITERAL_with);
							i3 = ident();
							if (inputState.guessing == 0) {
								loop.iterName(i3);
							}
							break;
						}
						case LCURLY: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			scope2(loop.scope());
			if (inputState.guessing == 0) {
				cr.add(loop);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_62);
			} else {
				throw ex;
			}
		}
	}

	public final void constructExpression2(
	  final BaseScope cr
	) throws RecognitionException, TokenStreamException {

		Qualident      q = null;
		ExpressionList o = null;

		try {      // for error handling
			match(LITERAL_construct);
			q = qualident();
			{
				if ((LA(1) == LPAREN) && (_tokenSet_84.member(LA(2)))) {
					match(LPAREN);
					{
						switch (LA(1)) {
						case IDENT:
						case STRING_LITERAL:
						case CHAR_LITERAL:
						case NUM_INT:
						case NUM_FLOAT:
						case LBRACK:
						case LPAREN:
						case LCURLY:
						case PLUS:
						case MINUS:
						case INC:
						case DEC:
						case BNOT:
						case LNOT:
						case LITERAL_true:
						case LITERAL_false:
						case LITERAL_this:
						case LITERAL_null:
						case LITERAL_function:
						case LITERAL_procedure: {
							o = expressionList();
							break;
						}
						case RPAREN: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(RPAREN);
				} else if ((_tokenSet_62.member(LA(1))) && (_tokenSet_85.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			if (inputState.guessing == 0) {
				cr.constructExpression(q, o);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_62);
			} else {
				throw ex;
			}
		}
	}

	public final void yieldExpression(
	  final BaseScope cr
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			match(LITERAL_yield);
			expr = expression();
			if (inputState.guessing == 0) {
				cr.yield(expr);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_62);
			} else {
				throw ex;
			}
		}
	}

	public final IExpression conditionalExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;

		try {      // for error handling
			ee = logicalOrExpression();
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression logicalOrExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		IExpression e3 = null;

		try {      // for error handling
			ee = logicalAndExpression();
			{
				do {
					if ((LA(1) == LOR) && (_tokenSet_19.member(LA(2)))) {
						match(LOR);
						e3 = logicalAndExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, ExpressionKind.LOR, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression logicalAndExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		IExpression e3 = null;

		try {      // for error handling
			ee = inclusiveOrExpression();
			{
				do {
					if ((LA(1) == LAND) && (_tokenSet_19.member(LA(2)))) {
						match(LAND);
						e3 = inclusiveOrExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, ExpressionKind.LAND, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression inclusiveOrExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		IExpression e3 = null;

		try {      // for error handling
			ee = exclusiveOrExpression();
			{
				do {
					if ((LA(1) == BOR) && (_tokenSet_19.member(LA(2)))) {
						match(BOR);
						e3 = exclusiveOrExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, ExpressionKind.BOR, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression exclusiveOrExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		IExpression e3 = null;

		try {      // for error handling
			ee = andExpression();
			{
				do {
					if ((LA(1) == BXOR) && (_tokenSet_19.member(LA(2)))) {
						match(BXOR);
						e3 = andExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, ExpressionKind.BXOR, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression andExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		IExpression e3 = null;

		try {      // for error handling
			ee = equalityExpression();
			{
				do {
					if ((LA(1) == BAND) && (_tokenSet_19.member(LA(2)))) {
						match(BAND);
						e3 = equalityExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, ExpressionKind.BAND, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression equalityExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		ExpressionKind e2 = null;
		IExpression    e3 = null;

		try {      // for error handling
			ee = relationalExpression();
			{
				do {
					if ((LA(1) == EQUAL || LA(1) == NOT_EQUAL) && (_tokenSet_19.member(LA(2)))) {
						{
							switch (LA(1)) {
							case NOT_EQUAL: {
								match(NOT_EQUAL);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.NOT_EQUAL;
								}
								break;
							}
							case EQUAL: {
								match(EQUAL);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.EQUAL;
								}
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						e3 = relationalExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, e2, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression relationalExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		ExpressionKind e2 = null; // should never be null (below)
		IExpression    e3 = null;
		TypeName       tn = null;

		try {      // for error handling
			ee = shiftExpression();
			{
				if ((_tokenSet_7.member(LA(1))) && (_tokenSet_81.member(LA(2)))) {
					{
						do {
							if ((_tokenSet_86.member(LA(1))) && (_tokenSet_19.member(LA(2)))) {
								{
									switch (LA(1)) {
									case LT_: {
										match(LT_);
										if (inputState.guessing == 0) {
											e2 = ExpressionKind.LT_;
										}
										break;
									}
									case GT: {
										match(GT);
										if (inputState.guessing == 0) {
											e2 = ExpressionKind.GT;
										}
										break;
									}
									case LE: {
										match(LE);
										if (inputState.guessing == 0) {
											e2 = ExpressionKind.LE;
										}
										break;
									}
									case GE: {
										match(GE);
										if (inputState.guessing == 0) {
											e2 = ExpressionKind.GE;
										}
										break;
									}
									default: {
										throw new NoViableAltException(LT(1), getFilename());
									}
									}
								}
								e3 = shiftExpression();
								if (inputState.guessing == 0) {
									ee = ExpressionBuilder.build(ee, e2, e3);
									ee.setType(new OS_BuiltinType(BuiltInTypes.Boolean));
								}
							} else {
								break;
							}

						} while (true);
					}
				} else if ((LA(1) == LITERAL_is_a) && (_tokenSet_87.member(LA(2)))) {
					match(LITERAL_is_a);
					tn = typeName2();
					if (inputState.guessing == 0) {
						ee = new TypeCheckExpression(ee, tn);
					}
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression shiftExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		ExpressionKind e2 = null;
		IExpression    e3 = null;

		try {      // for error handling
			ee = additiveExpression();
			{
				do {
					if (((LA(1) >= SL && LA(1) <= BSR)) && (_tokenSet_19.member(LA(2)))) {
						{
							switch (LA(1)) {
							case SL: {
								match(SL);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.LSHIFT;
								}
								break;
							}
							case SR: {
								match(SR);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.RSHIFT;
								}
								break;
							}
							case BSR: {
								match(BSR);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.BSHIFTR;
								}
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						e3 = additiveExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, e2, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression additiveExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		ExpressionKind e2 = null;
		IExpression    e3 = null;

		try {      // for error handling
			ee = multiplicativeExpression();
			{
				do {
					if ((LA(1) == PLUS || LA(1) == MINUS) && (_tokenSet_19.member(LA(2)))) {
						{
							switch (LA(1)) {
							case PLUS: {
								match(PLUS);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.ADDITION;
								}
								break;
							}
							case MINUS: {
								match(MINUS);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.SUBTRACTION;
								}
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						e3 = multiplicativeExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, e2, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression multiplicativeExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		IExpression    e3 = null;
		ExpressionKind e2 = null;

		try {      // for error handling
			ee = unaryExpression();
			{
				do {
					if (((LA(1) >= STAR && LA(1) <= MOD)) && (_tokenSet_19.member(LA(2)))) {
						{
							switch (LA(1)) {
							case STAR: {
								match(STAR);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.MULTIPLY;
								}
								break;
							}
							case DIV: {
								match(DIV);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.DIVIDE;
								}
								break;
							}
							case MOD: {
								match(MOD);
								if (inputState.guessing == 0) {
									e2 = ExpressionKind.MODULO;
								}
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						e3 = unaryExpression();
						if (inputState.guessing == 0) {
							ee = ExpressionBuilder.build(ee, e2, e3);
						}
					} else {
						break;
					}

				} while (true);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression unaryExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		final IExpression e3 = null;

		try {      // for error handling
			switch (LA(1)) {
			case INC: {
				match(INC);
				ee = unaryExpression();
				if (inputState.guessing == 0) {
					ee = new UnaryExpression(ExpressionKind.INCREMENT, ee);
				}
				break;
			}
			case DEC: {
				match(DEC);
				ee = unaryExpression();
				if (inputState.guessing == 0) {
					ee = new UnaryExpression(ExpressionKind.DECREMENT, ee);
				}
				break;
			}
			case MINUS: {
				match(MINUS);
				ee = unaryExpression();
				if (inputState.guessing == 0) {
					ee = new UnaryExpression(ExpressionKind.NEG, ee);
				}
				break;
			}
			case PLUS: {
				match(PLUS);
				ee = unaryExpression();
				if (inputState.guessing == 0) {
					ee = new UnaryExpression(ExpressionKind.POS, ee);
				}
				break;
			}
			case IDENT:
			case STRING_LITERAL:
			case CHAR_LITERAL:
			case NUM_INT:
			case NUM_FLOAT:
			case LBRACK:
			case LPAREN:
			case LCURLY:
			case BNOT:
			case LNOT:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_this:
			case LITERAL_null:
			case LITERAL_function:
			case LITERAL_procedure: {
				ee = unaryExpressionNotPlusMinus();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression unaryExpressionNotPlusMinus() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		final IExpression e3 = null;

		try {      // for error handling
			switch (LA(1)) {
			case BNOT: {
				match(BNOT);
				ee = unaryExpression();
				if (inputState.guessing == 0) {
					ee = new UnaryExpression(ExpressionKind.BNOT, ee);
				}
				break;
			}
			case LNOT: {
				match(LNOT);
				ee = unaryExpression();
				if (inputState.guessing == 0) {
					ee = new UnaryExpression(ExpressionKind.LNOT, ee);
				}
				break;
			}
			case IDENT:
			case STRING_LITERAL:
			case CHAR_LITERAL:
			case NUM_INT:
			case NUM_FLOAT:
			case LBRACK:
			case LPAREN:
			case LCURLY:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_this:
			case LITERAL_null:
			case LITERAL_function:
			case LITERAL_procedure: {
				ee = postfixExpression();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression postfixExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		Token lb = null;
		Token rb = null;
		Token lp = null;
		Token in = null;
		Token de = null;
		ee = null;
		TypeCastExpression tc = null;
		TypeName           tn = null;
		final IExpression  e3 = null;
		ExpressionList     el = null;

		try {      // for error handling
			ee = primaryExpression();
			{
				do {
					if ((LA(1) == DOT) && (LA(2) == IDENT)) {
						match(DOT);
						{
							ee = dot_expression_or_procedure_call(ee);
						}
					} else if ((LA(1) == LBRACK) && (_tokenSet_19.member(LA(2)))) {
						lb = LT(1);
						match(LBRACK);
						expr = expression();
						rb   = LT(1);
						match(RBRACK);
						if (inputState.guessing == 0) {
							ee = new GetItemExpression(ee, expr);
							((GetItemExpression) ee).parens(lb, rb);
						}
						{
							if ((LA(1) == BECOMES) && (_tokenSet_19.member(LA(2)))) {
								match(BECOMES);
								expr = expression();
								if (inputState.guessing == 0) {
									ee = new SetItemExpression((GetItemExpression) ee, expr);
								}
							} else if ((_tokenSet_7.member(LA(1))) && (_tokenSet_81.member(LA(2)))) {
							} else {
								throw new NoViableAltException(LT(1), getFilename());
							}

						}
					} else if ((LA(1) == LPAREN) && (_tokenSet_84.member(LA(2)))) {
						lp = LT(1);
						match(LPAREN);
						{
							switch (LA(1)) {
							case IDENT:
							case STRING_LITERAL:
							case CHAR_LITERAL:
							case NUM_INT:
							case NUM_FLOAT:
							case LBRACK:
							case LPAREN:
							case LCURLY:
							case PLUS:
							case MINUS:
							case INC:
							case DEC:
							case BNOT:
							case LNOT:
							case LITERAL_true:
							case LITERAL_false:
							case LITERAL_this:
							case LITERAL_null:
							case LITERAL_function:
							case LITERAL_procedure: {
								el = expressionList();
								break;
							}
							case RPAREN: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						if (inputState.guessing == 0) {
							final ProcedureCallExpression pce = new ProcedureCallExpression();
							pce.identifier(ee);
							pce.setArgs(el);
							ee = pce;
						}
						match(RPAREN);
					} else {
						break;
					}

				} while (true);
			}
			{
				if ((LA(1) == INC) && (_tokenSet_7.member(LA(2)))) {
					in = LT(1);
					match(INC);
					if (inputState.guessing == 0) {
						ee.setKind(ExpressionKind.POST_INCREMENT);
					}
				} else if ((LA(1) == DEC) && (_tokenSet_7.member(LA(2)))) {
					de = LT(1);
					match(DEC);
					if (inputState.guessing == 0) {
						ee.setKind(ExpressionKind.POST_DECREMENT);
					}
				} else if ((_tokenSet_7.member(LA(1))) && (_tokenSet_81.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			{
				if ((LA(1) == AS || LA(1) == CAST_TO) && (_tokenSet_87.member(LA(2)))) {
					if (inputState.guessing == 0) {
						tc = new TypeCastExpression();
						ee = tc;
					}
					{
						switch (LA(1)) {
						case AS: {
							match(AS);
							if (inputState.guessing == 0) {
								tc.setKind(ExpressionKind.AS_CAST);
							}
							break;
						}
						case CAST_TO: {
							match(CAST_TO);
							if (inputState.guessing == 0) {
								tc.setKind(ExpressionKind.CAST_TO);
							}
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					tn = typeName2();
					if (inputState.guessing == 0) {
						tc.setTypeName(tn);
					}
				} else if ((_tokenSet_7.member(LA(1))) && (_tokenSet_81.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression primaryExpression() throws RecognitionException, TokenStreamException {
		IExpression ee;

		ee = null;
		FuncExpr              ppc = null;
		final IdentExpression e   = null;
		ExpressionList        el  = null;

		try {      // for error handling
			switch (LA(1)) {
			case IDENT: {
				ee = ident();
				break;
			}
			case STRING_LITERAL:
			case CHAR_LITERAL:
			case NUM_INT:
			case NUM_FLOAT: {
				ee = constantValue();
				break;
			}
			case LITERAL_true: {
				match(LITERAL_true);
				break;
			}
			case LITERAL_false: {
				match(LITERAL_false);
				break;
			}
			case LITERAL_this: {
				match(LITERAL_this);
				break;
			}
			case LITERAL_null: {
				match(LITERAL_null);
				break;
			}
			case LPAREN: {
				match(LPAREN);
				ee = assignmentExpression();
				match(RPAREN);
				if (inputState.guessing == 0) {
					ee = new SubExpression(ee);
				}
				break;
			}
			case LCURLY:
			case LITERAL_function:
			case LITERAL_procedure: {
				if (inputState.guessing == 0) {
					ppc = new FuncExpr();
				}
				funcExpr(ppc);
				if (inputState.guessing == 0) {
					ee = ppc;
				}
				break;
			}
			case LBRACK: {
				match(LBRACK);
				if (inputState.guessing == 0) {
					ee = new ListExpression();
					el = new ExpressionList();
				}
				el = expressionList();
				if (inputState.guessing == 0) {
					((ListExpression) ee).setContents(el);
				}
				match(RBRACK);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final IExpression dot_expression_or_procedure_call(
	  final IExpression e1
	) throws RecognitionException, TokenStreamException {
		IExpression ee;

		Token lp2 = null;
		ee = null;
		ExpressionList  el = null;
		IdentExpression e  = null;

		try {      // for error handling
			e = ident();
			if (inputState.guessing == 0) {
				ee = new DotExpression(e1, e);
			}
			{
				if ((LA(1) == LPAREN) && (_tokenSet_84.member(LA(2)))) {
					lp2 = LT(1);
					match(LPAREN);
					{
						switch (LA(1)) {
						case IDENT:
						case STRING_LITERAL:
						case CHAR_LITERAL:
						case NUM_INT:
						case NUM_FLOAT:
						case LBRACK:
						case LPAREN:
						case LCURLY:
						case PLUS:
						case MINUS:
						case INC:
						case DEC:
						case BNOT:
						case LNOT:
						case LITERAL_true:
						case LITERAL_false:
						case LITERAL_this:
						case LITERAL_null:
						case LITERAL_function:
						case LITERAL_procedure: {
							el = expressionList();
							break;
						}
						case RPAREN: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					if (inputState.guessing == 0) {
						final ProcedureCallExpression pce = new ProcedureCallExpression();
						pce.identifier(ee);
						pce.setArgs(el);
						ee = pce;
					}
					match(RPAREN);
				} else if ((_tokenSet_7.member(LA(1))) && (_tokenSet_81.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return ee;
	}

	public final void funcExpr(
	  final FuncExpr pc
	) throws RecognitionException, TokenStreamException {

		Scope3          sc  = null;
		TypeName        tn  = null;
		FuncExprContext ctx = null;
		FormalArgList   fal = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_function: {
					match(LITERAL_function);
					if (inputState.guessing == 0) {
						pc.type(TypeModifiers.FUNCTION);
					}
					{
						fal = opfal();
						if (inputState.guessing == 0) {
							pc.setArgList(fal);
						}
					}
					if (inputState.guessing == 0) {
						ctx = new FuncExprContext(cur, pc);
						pc.setContext(ctx);
						cur = ctx;
					}
					sco = scope3(pc);
					if (inputState.guessing == 0) {
						pc.scope(sco);
					}
					{
						if ((LA(1) == TOK_COLON || LA(1) == TOK_ARROW) && (_tokenSet_87.member(LA(2)))) {
							{
								switch (LA(1)) {
								case TOK_ARROW: {
									match(TOK_ARROW);
									break;
								}
								case TOK_COLON: {
									match(TOK_COLON);
									break;
								}
								default: {
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
							}
							tn = typeName2();
							if (inputState.guessing == 0) {
								pc.setReturnType(tn);
							}
						} else if ((_tokenSet_7.member(LA(1))) && (_tokenSet_81.member(LA(2)))) {
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}

					}
					break;
				}
				case LITERAL_procedure: {
					match(LITERAL_procedure);
					if (inputState.guessing == 0) {
						pc.type(TypeModifiers.PROCEDURE);
					}
					{
						fal = opfal();
						if (inputState.guessing == 0) {
							pc.setArgList(fal);
						}
					}
					if (inputState.guessing == 0) {
						ctx = new FuncExprContext(cur, pc);
						pc.setContext(ctx);
						cur = ctx;
					}
					sco = scope3(pc);
					if (inputState.guessing == 0) {
						pc.scope(sco);
					}
					break;
				}
				case LCURLY: {
					if (inputState.guessing == 0) {
						sc = new Scope3(pc);
					}
					match(LCURLY);
					if (inputState.guessing == 0) {
						ctx = new FuncExprContext(cur, pc);
						pc.setContext(ctx);
						cur = ctx;
					}
					match(BOR);
					{
						switch (LA(1)) {
						case LPAREN: {
							fal = opfal();
							if (inputState.guessing == 0) {
								pc.setArgList(fal);
							}
							break;
						}
						case BOR: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(BOR);
					{
						do {
							if ((_tokenSet_50.member(LA(1))) && (_tokenSet_88.member(LA(2)))) {
								statement(sc.statementClosure(), sc.getParent());
							} else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_89.member(LA(2)))) {
								expr = expression();
								if (inputState.guessing == 0) {
									sc.statementWrapper(expr);
								}
							} else if ((LA(1) == LITERAL_class)) {
								classStatement(sc.getParent(), cur, null/*annotations*/);
							} else {
								break;
							}

						} while (true);
					}
					match(RCURLY);
					if (inputState.guessing == 0) {
						pc.scope(sc);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				pc.postConstruct();
				cur = cur.getParent();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
	}

	public final void elseif_part(
	  final IfConditional ifex
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_elseif: {
					match(LITERAL_elseif);
					break;
				}
				case LITERAL_else: {
					match(LITERAL_else);
					match(LITERAL_if);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			expr = expression();
			if (inputState.guessing == 0) {
				ifex.expr(expr);
				cur = ifex.getContext();
			}
			sco = scope3(ifex);
			if (inputState.guessing == 0) {
				ifex.scope(sco);
			}
			if (inputState.guessing == 0) {
				cur = cur.getParent();
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_90);
			} else {
				throw ex;
			}
		}
	}

	public final void elseif_part2(
	  final IfConditionalBuilder.Doublet ifex
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_elseif: {
					match(LITERAL_elseif);
					break;
				}
				case LITERAL_else: {
					match(LITERAL_else);
					match(LITERAL_if);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			expr = expression();
			if (inputState.guessing == 0) {
				ifex.expr(expr);
			}
			scope2(ifex.scope());
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_91);
			} else {
				throw ex;
			}
		}
	}

	public final TypeOfTypeName typeOfTypeName2() throws RecognitionException, TokenStreamException {
		final TypeOfTypeName tn;

		tn = new TypeOfTypeName(cur);

		try {      // for error handling
			match(LITERAL_typeof);
			xy = qualident();
			if (inputState.guessing == 0) {
				tn.typeOf(xy);
				tn.set(TypeModifiers.TYPE_OF);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return tn;
	}

	public final NormalTypeName normalTypeName2() throws RecognitionException, TokenStreamException {
		final NormalTypeName tn;

		tn = new RegularTypeName(cur);
		TypeNameList rtn = null;

		try {      // for error handling
			regularQualifiers2(tn);
			xy = qualident();
			if (inputState.guessing == 0) {
				tn.setName(xy);
			}
			{
				if ((LA(1) == LBRACK) && (_tokenSet_87.member(LA(2)))) {
					match(LBRACK);
					rtn = typeNameList2();
					if (inputState.guessing == 0) {
						tn.addGenericPart(rtn);
					}
					match(RBRACK);
				} else if ((_tokenSet_2.member(LA(1))) && (_tokenSet_92.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			{
				switch (LA(1)) {
				case QUESTION: {
					match(QUESTION);
					if (inputState.guessing == 0) {
						tn.setNullable();
					}
					break;
				}
				case EOF:
				case AS:
				case CAST_TO:
				case LITERAL_package:
				case IDENT:
				case TOK_COLON:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case NUM_INT:
				case NUM_FLOAT:
				case DOT:
				case LITERAL_class:
				case LBRACK:
				case RBRACK:
				case LPAREN:
				case RPAREN:
				case LCURLY:
				case RCURLY:
				case LITERAL_type:
				case BECOMES:
				case BOR:
				case ANNOT:
				case LITERAL_namespace:
				case LITERAL_from:
				case LITERAL_import:
				case COMMA:
				case LT_:
				case LITERAL_constructor:
				case LITERAL_ctor:
				case LITERAL_destructor:
				case LITERAL_dtor:
				case LITERAL_continue:
				case LITERAL_break:
				case LITERAL_return:
				case LITERAL_with:
				case LITERAL_post:
				case LITERAL_const:
				case LITERAL_var:
				case LITERAL_val:
				case LITERAL_alias:
				case LITERAL_yield:
				case LITERAL_construct:
				case SEMI:
				case LITERAL_invariant:
				case LITERAL_access:
				case EQUAL:
				case PLUS_ASSIGN:
				case MINUS_ASSIGN:
				case STAR_ASSIGN:
				case DIV_ASSIGN:
				case MOD_ASSIGN:
				case SR_ASSIGN:
				case BSR_ASSIGN:
				case SL_ASSIGN:
				case BAND_ASSIGN:
				case BXOR_ASSIGN:
				case BOR_ASSIGN:
				case LOR:
				case LAND:
				case BXOR:
				case BAND:
				case NOT_EQUAL:
				case GT:
				case LE:
				case GE:
				case LITERAL_is_a:
				case SL:
				case SR:
				case BSR:
				case PLUS:
				case MINUS:
				case STAR:
				case DIV:
				case MOD:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_this:
				case LITERAL_null:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_if:
				case LITERAL_match:
				case LITERAL_case:
				case LITERAL_while:
				case LITERAL_do:
				case LITERAL_iterate:
				case LITERAL_to:
				case LITERAL_def:
				case LITERAL_prop:
				case LITERAL_property: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return tn;
	}

	public final GenericTypeName genericTypeName2() throws RecognitionException, TokenStreamException {
		final GenericTypeName tn;

		tn = new GenericTypeName(cur);
		TypeName tn2 = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_generic: {
					match(LITERAL_generic);
					break;
				}
				case QUESTION: {
					match(QUESTION);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			xy = qualident();
			if (inputState.guessing == 0) {
				tn.typeName(xy);
				tn.set(TypeModifiers.GENERIC);
			}
			{
				if ((LA(1) == LT_) && (_tokenSet_87.member(LA(2)))) {
					match(LT_);
					tn2 = typeName2();
					if (inputState.guessing == 0) {
						tn.setConstraint(tn2);
					}
				} else if ((_tokenSet_7.member(LA(1))) && (_tokenSet_92.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return tn;
	}

	public final FuncTypeName functionTypeName2() throws RecognitionException, TokenStreamException {
		FuncTypeName tn;

		tn = null;

		try {      // for error handling
			switch (LA(1)) {
			case LITERAL_function:
			case LITERAL_func: {
				tn = functionTypeName2_function();
				break;
			}
			case LITERAL_procedure:
			case LITERAL_proc: {
				tn = functionTypeName2_procedure();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return tn;
	}

	public final void regularQualifiers2(
	  final NormalTypeName fp
	) throws RecognitionException, TokenStreamException {


		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_in: {
					match(LITERAL_in);
					if (inputState.guessing == 0) {
						fp.setIn(true);
					}
					break;
				}
				case LITERAL_out: {
					match(LITERAL_out);
					if (inputState.guessing == 0) {
						fp.setOut(true);
					}
					break;
				}
				case IDENT:
				case LITERAL_const:
				case LITERAL_ref: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case LITERAL_const: {
					{
						match(LITERAL_const);
						if (inputState.guessing == 0) {
							fp.setConstant(true);
						}
						{
							switch (LA(1)) {
							case LITERAL_ref: {
								match(LITERAL_ref);
								if (inputState.guessing == 0) {
									fp.setReference(true);
								}
								break;
							}
							case IDENT: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
					}
					break;
				}
				case LITERAL_ref: {
					match(LITERAL_ref);
					if (inputState.guessing == 0) {
						fp.setReference(true);
					}
					break;
				}
				case IDENT: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_93);
			} else {
				throw ex;
			}
		}
	}

	public final FuncTypeName functionTypeName2_function() throws RecognitionException, TokenStreamException {
		final FuncTypeName tn;

		tn = new FuncTypeName(cur);
		TypeName      rtn = null;
		TypeNameList  tnl = null;
		FormalArgList op  = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_function: {
					match(LITERAL_function);
					break;
				}
				case LITERAL_func: {
					match(LITERAL_func);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				tn.type(TypeModifiers.FUNCTION);
			}
			{
				match(LPAREN);
				{
					boolean synPredMatched406 = false;
					if (((_tokenSet_87.member(LA(1))) && (_tokenSet_94.member(LA(2))))) {
						final int _m406 = mark();
						synPredMatched406 = true;
						inputState.guessing++;
						try {
							{
								typeNameList2();
							}
						} catch (final RecognitionException pe) {
							synPredMatched406 = false;
						}
						rewind(_m406);
						inputState.guessing--;
					}
					if (synPredMatched406) {
						tnl = typeNameList2();
					} else if ((_tokenSet_95.member(LA(1))) && (_tokenSet_96.member(LA(2)))) {
						op = formalArgList();
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				match(RPAREN);
			}
			if (inputState.guessing == 0) {
				if (tnl != null) tn.argList(tnl);
				else tn.argList(op);
			}
			{
				if ((LA(1) == TOK_COLON || LA(1) == TOK_ARROW) && (_tokenSet_87.member(LA(2)))) {
					{
						switch (LA(1)) {
						case TOK_ARROW: {
							match(TOK_ARROW);
							break;
						}
						case TOK_COLON: {
							match(TOK_COLON);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					rtn = typeName2();
					if (inputState.guessing == 0) {
						tn.returnValue(rtn);
					}
				} else if ((_tokenSet_7.member(LA(1))) && (_tokenSet_92.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return tn;
	}

	public final FuncTypeName functionTypeName2_procedure() throws RecognitionException, TokenStreamException {
		final FuncTypeName tn;

		tn = new FuncTypeName(cur);
		TypeNameList  tnl = null;
		FormalArgList op  = null;

		try {      // for error handling
			{
				switch (LA(1)) {
				case LITERAL_procedure: {
					match(LITERAL_procedure);
					break;
				}
				case LITERAL_proc: {
					match(LITERAL_proc);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			if (inputState.guessing == 0) {
				tn.type(TypeModifiers.PROCEDURE);
			}
			{
				match(LPAREN);
				{
					boolean synPredMatched414 = false;
					if (((_tokenSet_87.member(LA(1))) && (_tokenSet_94.member(LA(2))))) {
						final int _m414 = mark();
						synPredMatched414 = true;
						inputState.guessing++;
						try {
							{
								typeNameList2();
							}
						} catch (final RecognitionException pe) {
							synPredMatched414 = false;
						}
						rewind(_m414);
						inputState.guessing--;
					}
					if (synPredMatched414) {
						tnl = typeNameList2();
					} else if ((_tokenSet_95.member(LA(1))) && (_tokenSet_97.member(LA(2)))) {
						op = formalArgList();
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				match(RPAREN);
			}
			if (inputState.guessing == 0) {
				if (tnl != null) tn.argList(tnl);
				else tn.argList(op);
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_7);
			} else {
				throw ex;
			}
		}
		return tn;
	}

	public final void formalArgListItem_priv(
	  final FormalArgListItem fali
	) throws RecognitionException, TokenStreamException {

		TypeName        tn = null;
		IdentExpression i  = null;

		try {      // for error handling
			{
				{
					if ((_tokenSet_98.member(LA(1))) && (_tokenSet_99.member(LA(2)))) {
						regularQualifiers2((NormalTypeName) fali.typeName());
					} else if ((LA(1) == IDENT) && (LA(2) == TOK_COLON || LA(2) == RPAREN || LA(2) == COMMA)) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				i = ident();
				if (inputState.guessing == 0) {
					fali.setName(i);
				}
				{
					switch (LA(1)) {
					case TOK_COLON: {
						match(TOK_COLON);
						tn = typeName2();
						if (inputState.guessing == 0) {
							fali.setTypeName(tn);
						}
						break;
					}
					case RPAREN:
					case COMMA: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			}
		} catch (final RecognitionException ex) {
			if (inputState.guessing == 0) {
				reportError(ex);
				recover(ex, _tokenSet_100);
			} else {
				throw ex;
			}
		}
	}

}

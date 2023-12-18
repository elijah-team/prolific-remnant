package tripleo.elijah.comp.internal;

import java.util.List;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.comp.i.CB_Action;
import tripleo.elijah.comp.i.CB_OutputString;
import tripleo.elijah.comp.i.CD_FindStdLib;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.i.ICompilationBus;
import tripleo.elijah.comp.i.Compilation.CompilationAlways;
import tripleo.elijah.comp.i.Compilation.CompilationAlways.Tokens;
import tripleo.elijah.util.Mode;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

import java.util.ArrayList;
import java.util.function.Consumer;


public final class CB_FindStdLibAction implements CB_Action {
   @NotNull
   private final CompilationEnclosure ce;
   @NotNull
   private final CR_State crState;
   @Nullable
   private CD_FindStdLib findStdLib;
   @NotNull
   private final List o;

   public CB_FindStdLibAction(@NotNull CompilationEnclosure ce, @NotNull CR_State crState) {
      Intrinsics.checkNotNullParameter(ce, "ce");
      Intrinsics.checkNotNullParameter(crState, "crState");

      this.ce = ce;
      this.crState = crState;
      this.o = new ArrayList<>();
      Operation op = this.obtain();
      this.logProgress(CB_FindStdLibAction.Prov.obtain, op);
   }

   private final Operation obtain() {
      Operation var10000 = this.ce.getCompilationDriver().get(Tokens.COMPILATION_RUNNER_FIND_STDLIB2);
      Intrinsics.checkNotNullExpressionValue(var10000, "get(...)");
      Operation x = var10000;
      if (x.mode() == Mode.SUCCESS) {
         Object var10001 = x.success();
         Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type tripleo.elijah.comp.i.CD_FindStdLib");
         this.findStdLib = (CD_FindStdLib)var10001;
      }

      return x;
   }

   public void execute() {
      this.logProgress(CB_FindStdLibAction.Prov.execute_begin, (Object)null);
      String var10000 = CompilationAlways.defaultPrelude();
      Intrinsics.checkNotNullExpressionValue(var10000, "defaultPrelude(...)");
      String preludeName = var10000;
      if (this.findStdLib != null) {
         CD_FindStdLib var3 = this.findStdLib;
         Intrinsics.checkNotNull(var3);
         Operation<Ok> var4 = var3.findStdLib(this.crState, preludeName, (Operation<CompilerInstructions> coci) -> {
        	 throw new Error();
         });
         Intrinsics.checkNotNullExpressionValue(var4, "findStdLib(...)");
         Operation op = var4;
         this.logProgress(CB_FindStdLibAction.Prov.find_stdlib, op);
         Mode var5 = op.mode();
         switch (var5 == null ? -1 : CB_FindStdLibAction.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()]) {
            case 1:
            case 2:
               break;
            default:
               throw new IllegalStateException("Unexpected value: " + op.mode());
         }
      }

      this.logProgress(CB_FindStdLibAction.Prov.execute_end, (Object)null);
   }

   private final void getPushItem(Operation oci) {
      this.logProgress(CB_FindStdLibAction.Prov.get_push_item, oci);
      if (oci.mode() == Mode.SUCCESS) {
         Compilation c = this.ce.getCompilation();
         c.use((CompilerInstructions)oci.success(), true);
      } else {
         throw new IllegalStateException((Throwable)oci.failure());
      }
   }

   private final void logProgress(Prov code, Object o) {
      String name = this.name();
      Operation op;
      String text;
      CB_OutputString os;
      switch (CB_FindStdLibAction.WhenMappings.$EnumSwitchMapping$1[code.ordinal()]) {
         case 1:
            Intrinsics.checkNotNull(o, "null cannot be cast to non-null type tripleo.elijah.util.Operation<tripleo.elijah.util.Ok>");
            op = (Operation)o;
            text = op.toString();
            os = (CB_OutputString)(new ICompilationBus.COutputString(text));
            this.outputStrings().add(os);
            break;
         case 2:
            Intrinsics.checkNotNull(o, "null cannot be cast to non-null type tripleo.elijah.util.Operation<tripleo.elijah.ci.i.CompilerInstructions>");
            op = (Operation)o;
            break;
         case 3:
            Intrinsics.checkNotNull(o, "null cannot be cast to non-null type tripleo.elijah.util.Operation<tripleo.elijah.comp.i.CompilerDriven>");
            op = (Operation)o;
            text = op.toString();
            os = (CB_OutputString)(new ICompilationBus.COutputString(text));
            this.outputStrings().add(os);
         case 4:
         case 5:
      }

   }

   @Contract(
      pure = true
   )
   @NotNull
   public String name() {
      return "find std lib";
   }

   @Contract(
      pure = true
   )
   @NotNull
   public List outputStrings() {
      return this.o;
   }

   private static final void execute$lambda$0(CB_FindStdLibAction this$0, Operation oci) {
      Intrinsics.checkNotNullParameter(this$0, "this$0");
      Intrinsics.checkNotNullParameter(oci, "oci");
      this$0.getPushItem(oci);
   }

   public static enum Prov {
      obtain,
      find_stdlib,
      get_push_item,
      execute_end,
      execute_begin;

//      // $FF: synthetic field
//      private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
//
//      @NotNull
//      public static EnumEntries getEntries() {
//         return $ENTRIES;
//      }

//      // $FF: synthetic method
//      private static final Prov[] $values() {
//         Prov[] var0 = new Prov[]{obtain, find_stdlib, get_push_item, execute_end, execute_begin};
//         return var0;
//      }
   }

   // $FF: synthetic class
   public class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[Mode.values().length];

         try {
            var0[Mode.SUCCESS.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[Mode.FAILURE.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[CB_FindStdLibAction.Prov.values().length];

         try {
            var0[CB_FindStdLibAction.Prov.find_stdlib.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[CB_FindStdLibAction.Prov.get_push_item.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[CB_FindStdLibAction.Prov.obtain.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[CB_FindStdLibAction.Prov.execute_end.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CB_FindStdLibAction.Prov.execute_begin.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}

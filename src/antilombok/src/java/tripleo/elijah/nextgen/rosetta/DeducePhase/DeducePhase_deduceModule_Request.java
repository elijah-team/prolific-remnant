package tripleo.elijah.nextgen.rosetta.DeducePhase;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.rosetta.Rosetta;
import tripleo.elijah.nextgen.rosetta.DeduceTypes2.DeduceTypes2Request;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.logging.ElLog;

public final class DeducePhase_deduceModule_Request {
   @NotNull
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @NotNull
   private final OS_Module module;
   @NotNull
   private final Iterable listOfEvaFunctions;
   @NotNull
   private final ElLog.Verbosity verbosity;
   @NotNull
   private final DeducePhase deducePhase;
   @Nullable
   private DeduceTypes2 createdDeduceTypes2;

   public DeducePhase_deduceModule_Request(@NotNull OS_Module module, @NotNull Iterable listOfEvaFunctions, @NotNull ElLog.Verbosity verbosity, @NotNull DeducePhase deducePhase) {
      Intrinsics.checkNotNullParameter(module, "module");
      Intrinsics.checkNotNullParameter(listOfEvaFunctions, "listOfEvaFunctions");
      Intrinsics.checkNotNullParameter(verbosity, "verbosity");
      Intrinsics.checkNotNullParameter(deducePhase, "deducePhase");
      
      this.module = module;
      this.listOfEvaFunctions = listOfEvaFunctions;
      this.verbosity = verbosity;
      this.deducePhase = deducePhase;
   }

   @NotNull
   public final OS_Module getModule() {
      return this.module;
   }

   @NotNull
   public final Iterable getListOfEvaFunctions() {
      return this.listOfEvaFunctions;
   }

   @NotNull
   public final ElLog.Verbosity getVerbosity() {
      return this.verbosity;
   }

   @NotNull
   public final DeducePhase getDeducePhase() {
      return this.deducePhase;
   }

   @NotNull
   public final DeduceTypes2 createDeduceTypes2() {
      DeduceTypes2Request deduceTypes2Request = new DeduceTypes2Request(this.module, this.deducePhase, this.verbosity);
      DeduceTypes2 var10000 = Rosetta.create(deduceTypes2Request);
      Intrinsics.checkNotNullExpressionValue(var10000, "create(...)");
      return var10000;
   }

   @NotNull
   public final OS_Module component1() {
      return this.module;
   }

   @NotNull
   public final Iterable component2() {
      return this.listOfEvaFunctions;
   }

   @NotNull
   public final ElLog.Verbosity component3() {
      return this.verbosity;
   }

   @NotNull
   public final DeducePhase component4() {
      return this.deducePhase;
   }

   @NotNull
   public final DeducePhase_deduceModule_Request copy(@NotNull OS_Module module, @NotNull Iterable listOfEvaFunctions, @NotNull ElLog.Verbosity verbosity, @NotNull DeducePhase deducePhase) {
      Intrinsics.checkNotNullParameter(module, "module");
      Intrinsics.checkNotNullParameter(listOfEvaFunctions, "listOfEvaFunctions");
      Intrinsics.checkNotNullParameter(verbosity, "verbosity");
      Intrinsics.checkNotNullParameter(deducePhase, "deducePhase");
      return new DeducePhase_deduceModule_Request(module, listOfEvaFunctions, verbosity, deducePhase);
   }

   // $FF: synthetic method
   public static DeducePhase_deduceModule_Request copy$default(DeducePhase_deduceModule_Request var0, OS_Module var1, Iterable var2, ElLog.Verbosity var3, DeducePhase var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.module;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.listOfEvaFunctions;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.verbosity;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.deducePhase;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   @NotNull
   public String toString() {
      return "DeducePhase_deduceModule_Request(module=" + this.module + ", listOfEvaFunctions=" + this.listOfEvaFunctions + ", verbosity=" + this.verbosity + ", deducePhase=" + this.deducePhase + ")";
   }

   public int hashCode() {
      int result = this.module.hashCode();
      result = result * 31 + this.listOfEvaFunctions.hashCode();
      result = result * 31 + this.verbosity.hashCode();
      result = result * 31 + this.deducePhase.hashCode();
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof DeducePhase_deduceModule_Request)) {
         return false;
      } else {
         DeducePhase_deduceModule_Request var2 = (DeducePhase_deduceModule_Request)other;
         if (!Intrinsics.areEqual(this.module, var2.module)) {
            return false;
         } else if (!Intrinsics.areEqual(this.listOfEvaFunctions, var2.listOfEvaFunctions)) {
            return false;
         } else if (this.verbosity != var2.verbosity) {
            return false;
         } else {
            return Intrinsics.areEqual(this.deducePhase, var2.deducePhase);
         }
      }
   }

   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final DeduceTypes2 createDeduceTypes2Singleton(@NotNull DeducePhase_deduceModule_Request moduleRequest) {
         Intrinsics.checkNotNullParameter(moduleRequest, "moduleRequest");
         if (moduleRequest.createdDeduceTypes2 == null) {
            moduleRequest.createdDeduceTypes2 = moduleRequest.createDeduceTypes2();
         }

         DeduceTypes2 var10000 = moduleRequest.createdDeduceTypes2;
         Intrinsics.checkNotNull(var10000);
         return var10000;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

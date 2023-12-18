package tripleo.elijah.nextgen.output;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.comp_model.CM_Module;

public final class NG_OutDep implements CM_Module {
   @NotNull
   private final OS_Module module_;

   public NG_OutDep(@NotNull OS_Module module_) {
      Intrinsics.checkNotNullParameter(module_, "module_");
      
      this.module_ = module_;
   }

   @NotNull
   public final OS_Module getModule_() {
      return this.module_;
   }

   @NotNull
   public String getFilename() {
      String var10000 = this.module_.getFileName().getString();
      Intrinsics.checkNotNullExpressionValue(var10000, "getString(...)");
      return var10000;
   }

   @NotNull
   public OS_Module getModule() {
      return this.module_;
   }

   @NotNull
   public final OS_Module component1() {
      return this.module_;
   }

   @NotNull
   public final NG_OutDep copy(@NotNull OS_Module module_) {
      Intrinsics.checkNotNullParameter(module_, "module_");
      return new NG_OutDep(module_);
   }

   // $FF: synthetic method
   public static NG_OutDep copy$default(NG_OutDep var0, OS_Module var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.module_;
      }

      return var0.copy(var1);
   }

   @NotNull
   public String toString() {
      return "NG_OutDep(module_=" + this.module_ + ")";
   }

   public int hashCode() {
      return this.module_.hashCode();
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof NG_OutDep)) {
         return false;
      } else {
         NG_OutDep var2 = (NG_OutDep)other;
         return Intrinsics.areEqual(this.module_, var2.module_);
      }
   }
}

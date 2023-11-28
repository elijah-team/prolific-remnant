package tripleo.elijah.nextgen.output;

import kotlin.Lazy;
import kotlin.LazyKt;
//import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.comp_model.CM_Module;

/*
@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"},
   d2 = {"Ltripleo/elijah/nextgen/output/NG_OutDep;", "Ltripleo/elijah/nextgen/comp_model/CM_Module;", "module_", "Ltripleo/elijah/lang/i/OS_Module;", "(Ltripleo/elijah/lang/i/OS_Module;)V", "filename_", "", "getFilename_", "()Ljava/lang/String;", "filename_$delegate", "Lkotlin/Lazy;", "getModule_", "()Ltripleo/elijah/lang/i/OS_Module;", "component1", "copy", "equals", "", "other", "", "getFilename", "getModule", "hashCode", "", "toString", "elijah-prolific-remnant"}
)
*/
public final class NG_OutDep implements CM_Module {
   @NotNull
   private final OS_Module module_;
   @NotNull
   private final Lazy filename_$delegate;

   public NG_OutDep(@NotNull OS_Module module_) {
      Intrinsics.checkNotNullParameter(module_, "module_");
//      super();
      this.module_ = module_;
      this.filename_$delegate = LazyKt.lazy((Function0)(new Function0() {
         public final String invoke() {
            return NG_OutDep.this.getModule_().getFileName().getString();
         }
      }));
   }

   @NotNull
   public final OS_Module getModule_() {
      return this.module_;
   }

   @NotNull
   public final String getFilename_() {
      Lazy var1 = this.filename_$delegate;
      Object var10000 = var1.getValue();
      Intrinsics.checkNotNullExpressionValue(var10000, "<get-filename_>(...)");
      return (String)var10000;
   }

   @NotNull
   public String getFilename() {
      return this.getFilename_();
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
      return "NG_OutDep(module_=" + this.module_ + ')';
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

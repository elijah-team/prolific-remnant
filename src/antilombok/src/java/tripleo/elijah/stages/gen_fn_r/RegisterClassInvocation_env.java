package tripleo.elijah.stages.gen_fn_r;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.stages.deduce.ClassInvocation;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.DeduceTypes2;

public final class RegisterClassInvocation_env {
   @NotNull
   private final ClassInvocation ci;
   @Nullable
   private final DeduceTypes2 deduceTypes2;
   @Nullable
   private final DeducePhase phase;

   public RegisterClassInvocation_env(@NotNull ClassInvocation ci, @Nullable DeduceTypes2 deduceTypes2, @Nullable DeducePhase phase) {
      Intrinsics.checkNotNullParameter(ci, "ci");
      
      this.ci = ci;
      this.deduceTypes2 = deduceTypes2;
      this.phase = phase;
   }

   @NotNull
   public final ClassInvocation getCi() {
      return this.ci;
   }

   @Nullable
   public final DeduceTypes2 getDeduceTypes2() {
      return this.deduceTypes2;
   }

   @Nullable
   public final DeducePhase getPhase() {
      return this.phase;
   }

   @NotNull
   public final ClassInvocation ci() {
      return this.ci;
   }

   @NotNull
   public final DeduceTypes2 deduceTypes2() {
      DeduceTypes2 var10000 = this.deduceTypes2;
      Intrinsics.checkNotNull(var10000);
      return var10000;
   }

   @NotNull
   public final DeducePhase phase() {
      DeducePhase var10000 = this.phase;
      Intrinsics.checkNotNull(var10000);
      return var10000;
   }

   @NotNull
   public final ClassInvocation component1() {
      return this.ci;
   }

   @Nullable
   public final DeduceTypes2 component2() {
      return this.deduceTypes2;
   }

   @Nullable
   public final DeducePhase component3() {
      return this.phase;
   }

   @NotNull
   public final RegisterClassInvocation_env copy(@NotNull ClassInvocation ci, @Nullable DeduceTypes2 deduceTypes2, @Nullable DeducePhase phase) {
      Intrinsics.checkNotNullParameter(ci, "ci");
      return new RegisterClassInvocation_env(ci, deduceTypes2, phase);
   }

   // $FF: synthetic method
   public static RegisterClassInvocation_env copy$default(RegisterClassInvocation_env var0, ClassInvocation var1, DeduceTypes2 var2, DeducePhase var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.ci;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.deduceTypes2;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.phase;
      }

      return var0.copy(var1, var2, var3);
   }

   @NotNull
   public String toString() {
      return "RegisterClassInvocation_env(ci=" + this.ci + ", deduceTypes2=" + this.deduceTypes2 + ", phase=" + this.phase + ")";
   }

   public int hashCode() {
      int result = this.ci.hashCode();
      result = result * 31 + (this.deduceTypes2 == null ? 0 : this.deduceTypes2.hashCode());
      result = result * 31 + (this.phase == null ? 0 : this.phase.hashCode());
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof RegisterClassInvocation_env)) {
         return false;
      } else {
         RegisterClassInvocation_env var2 = (RegisterClassInvocation_env)other;
         if (!Intrinsics.areEqual(this.ci, var2.ci)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deduceTypes2, var2.deduceTypes2)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.phase, var2.phase);
         }
      }
   }
}

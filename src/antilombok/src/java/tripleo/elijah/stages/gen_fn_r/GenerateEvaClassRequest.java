package tripleo.elijah.stages.gen_fn_r;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.stages.deduce.ClassInvocation;
import tripleo.elijah.stages.gen_fn.GenerateFunctions;

public final class GenerateEvaClassRequest {
   @NotNull
   private final GenerateFunctions generateFunctions;
   @NotNull
   private final ClassStatement classStatement;
   @NotNull
   private final ClassInvocation classInvocation;
   @NotNull
   private final RegisterClassInvocation_env passthruEnv;

   public GenerateEvaClassRequest(@NotNull GenerateFunctions generateFunctions, @NotNull ClassStatement classStatement, @NotNull ClassInvocation classInvocation, @NotNull RegisterClassInvocation_env passthruEnv) {
      Intrinsics.checkNotNullParameter(generateFunctions, "generateFunctions");
      Intrinsics.checkNotNullParameter(classStatement, "classStatement");
      Intrinsics.checkNotNullParameter(classInvocation, "classInvocation");
      Intrinsics.checkNotNullParameter(passthruEnv, "passthruEnv");
      
      this.generateFunctions = generateFunctions;
      this.classStatement = classStatement;
      this.classInvocation = classInvocation;
      this.passthruEnv = passthruEnv;
   }

   @NotNull
   public final GenerateFunctions getGenerateFunctions() {
      return this.generateFunctions;
   }

   @NotNull
   public final ClassStatement getClassStatement() {
      return this.classStatement;
   }

   @NotNull
   public final ClassInvocation getClassInvocation() {
      return this.classInvocation;
   }

   @NotNull
   public final RegisterClassInvocation_env getPassthruEnv() {
      return this.passthruEnv;
   }

   @NotNull
   public final GenerateFunctions component1() {
      return this.generateFunctions;
   }

   @NotNull
   public final ClassStatement component2() {
      return this.classStatement;
   }

   @NotNull
   public final ClassInvocation component3() {
      return this.classInvocation;
   }

   @NotNull
   public final RegisterClassInvocation_env component4() {
      return this.passthruEnv;
   }

   @NotNull
   public final GenerateEvaClassRequest copy(@NotNull GenerateFunctions generateFunctions, @NotNull ClassStatement classStatement, @NotNull ClassInvocation classInvocation, @NotNull RegisterClassInvocation_env passthruEnv) {
      Intrinsics.checkNotNullParameter(generateFunctions, "generateFunctions");
      Intrinsics.checkNotNullParameter(classStatement, "classStatement");
      Intrinsics.checkNotNullParameter(classInvocation, "classInvocation");
      Intrinsics.checkNotNullParameter(passthruEnv, "passthruEnv");
      return new GenerateEvaClassRequest(generateFunctions, classStatement, classInvocation, passthruEnv);
   }

   // $FF: synthetic method
   public static GenerateEvaClassRequest copy$default(GenerateEvaClassRequest var0, GenerateFunctions var1, ClassStatement var2, ClassInvocation var3, RegisterClassInvocation_env var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.generateFunctions;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.classStatement;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.classInvocation;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.passthruEnv;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   @NotNull
   public String toString() {
      return "GenerateEvaClassRequest(generateFunctions=" + this.generateFunctions + ", classStatement=" + this.classStatement + ", classInvocation=" + this.classInvocation + ", passthruEnv=" + this.passthruEnv + ")";
   }

   public int hashCode() {
      int result = this.generateFunctions.hashCode();
      result = result * 31 + this.classStatement.hashCode();
      result = result * 31 + this.classInvocation.hashCode();
      result = result * 31 + this.passthruEnv.hashCode();
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof GenerateEvaClassRequest)) {
         return false;
      } else {
         GenerateEvaClassRequest var2 = (GenerateEvaClassRequest)other;
         if (!Intrinsics.areEqual(this.generateFunctions, var2.generateFunctions)) {
            return false;
         } else if (!Intrinsics.areEqual(this.classStatement, var2.classStatement)) {
            return false;
         } else if (!Intrinsics.areEqual(this.classInvocation, var2.classInvocation)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.passthruEnv, var2.passthruEnv);
         }
      }
   }
}

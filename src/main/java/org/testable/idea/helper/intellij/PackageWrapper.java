package org.testable.idea.helper.intellij;


import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiPackage;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a package.
 *  @author dsl
 */
public class PackageWrapper {
    private final PsiManager myManager;
    @NotNull private final String myQualifiedName;

    public PackageWrapper(PsiManager manager, @NotNull String qualifiedName) {
        myManager = manager;
        myQualifiedName = qualifiedName;
    }

    public PackageWrapper(PsiPackage aPackage) {
        myManager = aPackage.getManager();
        myQualifiedName = aPackage.getQualifiedName();
    }

    public PsiManager getManager() { return myManager; }

    public PsiDirectory[] getDirectories() {
        return getDirectories(GlobalSearchScope.projectScope(myManager.getProject()));
    }

    public PsiDirectory[] getDirectories(@NotNull GlobalSearchScope scope) {
        String qName = myQualifiedName;
        while (qName.endsWith(".")) {
            qName = StringUtil.trimEnd(qName, ".");
        }
        final PsiPackage aPackage = JavaPsiFacade.getInstance(myManager.getProject()).findPackage(qName);
        if (aPackage != null) {
            return aPackage.getDirectories(scope);
        } else {
            return PsiDirectory.EMPTY_ARRAY;
        }
    }

    public boolean exists() {
        final Project project = myManager.getProject();
        final PsiPackage aPackage = JavaPsiFacade.getInstance(project).findPackage(myQualifiedName);
        return aPackage != null && aPackage.getDirectories(GlobalSearchScope.projectScope(project)).length > 0;
    }

    @NotNull
    public String getQualifiedName() {
        return myQualifiedName;
    }

    public boolean equalToPackage(PsiPackage aPackage) {
        return aPackage != null && myQualifiedName.equals(aPackage.getQualifiedName());
    }

    public static PackageWrapper create(PsiPackage aPackage) {
        return new PackageWrapper(aPackage);
    }
}

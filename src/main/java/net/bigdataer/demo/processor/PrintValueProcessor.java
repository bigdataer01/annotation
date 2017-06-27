package net.bigdataer.demo.processor;

import net.bigdataer.demo.annotation.PrintValueAnnotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Created by liuxuecheng on 2017/6/22.
 *
 * @58corp
 */
@SupportedAnnotationTypes({"net.bigdataer.demo.annotation.PrintValueAnnotation"})
public class PrintValueProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager msger = processingEnv.getMessager();
        for(TypeElement annotation:annotations){
            for(Element element :roundEnv.getElementsAnnotatedWith(annotation)){
                VariableElement var = (VariableElement) element;
                msger.printMessage(Diagnostic.Kind.NOTE,"element value%s");
            }
        }
        return false;
    }
}

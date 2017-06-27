package net.bigdataer.demo.processor;

import net.bigdataer.demo.annotation.VersionCheckAnnotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Created by liuxuecheng on 2017/6/26.
 */
@SupportedAnnotationTypes("net.bigdataer.demo.annotation.VersionCheckAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class VersionCheckProcessor extends AbstractProcessor {
    private Messager messager;
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //遍历被VersionCheckAnnotation标记的元素
        for(Element element:roundEnv.getElementsAnnotatedWith(VersionCheckAnnotation.class)){
            //获取当前元素上的注解
            VersionCheckAnnotation versionCheckAnnotation = element.getAnnotation(VersionCheckAnnotation.class);
            int major_version = versionCheckAnnotation.major_version();
            int minor_version = versionCheckAnnotation.minor_version();
            if(major_version<minor_version){
                messager.printMessage(Diagnostic.Kind.ERROR,"major_version should bigger than minor_version",element);
            }
        }

        //此处布尔值表示传入的一组注解是否是本注解处理器声明的，若是返回true，其他的处理器将不再对这些注解进行处理
        return true;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }
}

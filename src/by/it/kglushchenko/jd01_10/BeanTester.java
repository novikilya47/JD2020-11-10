package by.it.kglushchenko.jd01_10;


import java.lang.reflect.Method;


public class BeanTester {
    public static void main(String[] args) throws Exception {
        //processParamCreate(Bean.class);
        Class<Bean> cls = Bean.class;
        if (cls.isAnnotationPresent(Param.class)) {             // проверяем есть ли аннотация Param
            Param ann = cls.getAnnotation(Param.class);         // получили саму анотацию
            System.out.println((cls.isAnnotationPresent(Param.class)));

            //cls.getAnnotations();            // все аннотации класса и его суперклассов
            //cls.getDeclaredAnnotations();    // все аннотации самого класса

            System.out.println("Поле в Param аннотации a=" + ann.a());
            System.out.println("Поле в Param аннотации b=" + ann.b());

            try {
                Method[] methods = cls.getMethods();
                Object o = null;
                for (Method m : methods) { //ищем метод init и если он есть, то создаем экземпляр класса
                    if (m.isAnnotationPresent(Param.class)) {
                        if (o == null)
                            o = cls.getDeclaredConstructor().newInstance();      //создали экземпляр класса  помеченного @Service
                        m.invoke(o);                  //вызывали метод помеченный @Param

                    }
                }

                cls.getName();       //полное имя
                cls.getSimpleName(); //только имя
                cls.getModifiers();  //модификаторы доступа
                cls.getSuperclass(); //родитель
                cls.getInterfaces(); //получили интерфейсы класса
                //получим публичные поля конструкторы и методы класса и его суперклассов
                cls.getMethods();
                cls.getConstructors();
                cls.getFields();
                //получим ВСЕ поля конструкторы и методы самого класса
                cls.getDeclaredMethods();
                cls.getDeclaredConstructors();
                cls.getDeclaredFields();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    /**
     *
     */
    /*
    static void processParamCreate(Class<?> cls) {
        if (cls.isAnnotationPresent(Param.class)) {             // проверяем есть ли аннотация
            Param ann = cls.getAnnotation(Param.class);         // получили саму анотацию
            System.out.println((cls.isAnnotationPresent(Param.class)));

            //cls.getAnnotations();            // все аннотации класса и его суперклассов
            //cls.getDeclaredAnnotations();    // все аннотации самого класса

            System.out.println("Поле в Param аннотации a=" + ann.a());
            System.out.println("Поле в Param аннотации b=" + ann.b());

            try {
                Method[] methods = cls.getMethods();
                Object o = null;
                for (Method m : methods) { //ищем метод init и если он есть, то создаем экземпляр класса
                    if (m.isAnnotationPresent(Param.class)) {
                        if (o == null)
                            o = cls.getDeclaredConstructor().newInstance();      //создали экземпляр класса  помеченного @Service
                        m.invoke(o);                  //вызывали метод помеченный @Param

                    }
                }

                cls.getName();       //полное имя
                cls.getSimpleName(); //только имя
                cls.getModifiers();  //модификаторы доступа
                cls.getSuperclass(); //родитель
                cls.getInterfaces(); //получили интерфейсы класса
                //получим публичные поля конструкторы и методы класса и его суперклассов
                cls.getMethods();
                cls.getConstructors();
                cls.getFields();
                //получим ВСЕ поля конструкторы и методы самого класса
                cls.getDeclaredMethods();
                cls.getDeclaredConstructors();
                cls.getDeclaredFields();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }*/
/*
        HomeWork run = run("", true);
        Class<?> bean = findClass("Bean");
        Class<? extends Annotation> anno = (Class<? extends Annotation>) findClass("Param");
        Method a = anno.getMethod("a");
        Method b = anno.getMethod("b");
        Object instance = bean.getDeclaredConstructor().newInstance();
        Method[] methods = bean.getDeclaredMethods();
        System.out.println();
 */
}

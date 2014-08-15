package eventTracer;

import java.awt.*;
import java.beans.*;
import java.lang.reflect.*;

/**
 * @version 1.31 2004-05-10
 * @author Cay Horstmann
 */
public class EventTracer
{
   private InvocationHandler handler;

   public EventTracer()
   {
      // handler wszystkich obiektów poœrednich zdarzeñ
      handler = new InvocationHandler()
         {
            public Object invoke(Object proxy, Method method, Object[] args)
            {
               System.out.println(method + ":" + args[0]);
               return null;
            }
         };
   }

   /**
    * Dodawanie obiektów œledz¹cych zdarzenia dla wszystkich zdarzeñ, których ten komponent i jego potomkowie mog¹ nas³uchiwaæ
    * @param c a component
    */
   public void add(Component c)
   {
      try
      {
         // Pobranie wszystkich zdarzeñ, których ten komponent mo¿e nas³uchiwaæ
         BeanInfo info = Introspector.getBeanInfo(c.getClass());

         EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
         for (EventSetDescriptor eventSet : eventSets)
            addListener(c, eventSet);
      }
      catch (IntrospectionException e)
      {
      }
      // W razie wyst¹pienia wyj¹tku nie dodawaæ s³uchaczy

      if (c instanceof Container)
      {
         // Pobranie wszystkich potomków i rekursywne wywo³anie metody add
         for (Component comp : ((Container) c).getComponents())
            add(comp);
      }
   }

   /**
    * Dodanie s³uchacza do danego zbioru zdarzeñ
    * @param c a komponent
    * @param eventSet deskryptor interfejsu nas³uchuj¹cego
    */
   public void addListener(Component c, EventSetDescriptor eventSet)
   {
      // Utworzenie obiektu poœredniego dla tego typu s³uchaczy i przekazanie wszystkich wywo³añ do handlera

      Object proxy = Proxy.newProxyInstance(null, new Class[] { eventSet.getListenerType() },
            handler);

      // Dodanie obiektu poœredniego jako s³uchacza do komponentu
      Method addListenerMethod = eventSet.getAddListenerMethod();
      try
      {
         addListenerMethod.invoke(c, proxy);
      }
      catch (ReflectiveOperationException e)
      {
      }
      // W razie wyst¹pienia wyj¹tku nie dodawaæ s³uchaczy
   }
}

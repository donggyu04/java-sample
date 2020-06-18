package com.training.eventlistener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ListenerSupport<T> {

   private final List<T> listeners = new LinkedList<>();

   public void add(T listener) {
      synchronized (listeners) {
         listeners.add(listener);
      }
   }

   public void remove(T listener) {
      synchronized (listeners) {
         listeners.remove(listener);
      }
   }

   public void apply(Informer<? super T> informer) {
      for (T listener : cloneListenerList()) {
         informer.inform(listener);
      }
   }

   public boolean apply(HandlingInformer<? super T> handler) {
      for (T listener : cloneListenerList()) {
         if (handler.inform(listener)) {
            return true;
         }
      }
      return false;
   }

   private List<T> cloneListenerList() {
      synchronized (listeners) {
         return new ArrayList<>(listeners);
      }
   }

   public interface Informer<K> {
      void inform(K listener);
   }

   public interface HandlingInformer<K> {
      boolean inform(K listener);
   }
}

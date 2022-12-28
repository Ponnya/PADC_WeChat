//package com.padc.ponnya.wechat.utils
//
//import android.R
//import android.content.Context
//import android.util.AttributeSet
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.AdapterView
//import android.widget.SpinnerAdapter
//import android.widget.TextView
//import androidx.appcompat.widget.AppCompatSpinner
//import java.lang.reflect.InvocationHandler
//import java.lang.reflect.InvocationTargetException
//import java.lang.reflect.Method
//import java.lang.reflect.Proxy
//import java.security.AccessController.getContext
//
//
//class NoDefaultSpinner(context: Context, attrs: AttributeSet, defStyle: Int) :
//    AppCompatSpinner(context, attrs, defStyle) {
//    override fun setAdapter(adapter: SpinnerAdapter?) {
//        super.setAdapter(adapter);
//
//        try {
//            val m: Method = (AdapterView::class.java).getDeclaredMethod(
//                "setNextSelectedPositionInt", Int::class.java
//            )
//            m.isAccessible = true
//            m.invoke(this, -1)
//
//            val n: Method = (AdapterView::class.java).getDeclaredMethod(
//                "setSelectedPositionInt", Int::class.java
//            )
//            n.isAccessible = true;
//            n.invoke(this, -1);
//        } catch (e: Exception) {
//            throw RuntimeException(e);
//        }
//    }
//
//    protected fun newProxy(obj: SpinnerAdapter): SpinnerAdapter? {
//        return Proxy.newProxyInstance(
//            obj.javaClass.classLoader, arrayOf<Class<*>>(SpinnerAdapter::class.java),
//            SpinnerAdapterProxy(obj)
//        ) as SpinnerAdapter
//    }
//
//    protected class SpinnerAdapterProxy protected constructor(protected var obj: SpinnerAdapter) :
//        InvocationHandler {
//        protected var getView: Method? = null
//
//        init {
//            try {
//                getView = SpinnerAdapter::class.java.getMethod(
//                    "getView", Int::class.javaPrimitiveType, View::class.java, ViewGroup::class.java
//                )
//            } catch (e: java.lang.Exception) {
//                throw java.lang.RuntimeException(e)
//            }
//        }
//
//        @Throws(Throwable::class)
//        override operator fun invoke(proxy: Any?, m: Method, args: Array<Any>): Any {
//            return try {
//                if (m == getView &&
//                    (args[0] as Int)<0
//                        ) getView(
//                    args[0] as Int,
//                    args[1] as View,
//                    args[2] as ViewGroup
//                ) else m.invoke(
//                    obj, *args
//                )
//            } catch (e: InvocationTargetException) {
//                throw e.getTargetException()
//            } catch (e: java.lang.Exception) {
//                throw java.lang.RuntimeException(e)
//            }
//        }
//
//        @Throws(IllegalAccessException::class)
//        protected fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//            if (position < 0) {
//                val v = (getContext().systemService(
//                    Context.LAYOUT_INFLATER_SERVICE
//                ) as LayoutInflater).inflate(
//                    R.layout.simple_spinner_item, parent, false
//                ) as TextView
//                v.setText(getPro)
//                return v
//            }
//            return obj.getView(position, convertView, parent)
//        }
//
//
//    }
//
//}
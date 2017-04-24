package com.zhuwd.rxjava.viewholder;
import android.util.SparseArray;
import android.view.View;

public class ViewHolder {
    public static <T> T get(View view, int id) {
        View target;
        SparseArray<View> views = (SparseArray<View>) view.getTag();
        if (views == null) {
            views = new SparseArray<>();
            view.setTag(views);
        }
        target = views.get(id);
        if (target == null) {
            target = view.findViewById(id);
            views.put(id, target);
        }
        return (T) target;
    }
}

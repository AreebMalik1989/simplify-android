package github.areebmalik1989.simplify_resources;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class SimplifyBitmap {

    public static byte[] bytesFromBitmap(Bitmap bitmap){

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);

        return baos.toByteArray();
    }

    public static Bitmap bitmapFromByteArray(byte[] bytes){

        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}

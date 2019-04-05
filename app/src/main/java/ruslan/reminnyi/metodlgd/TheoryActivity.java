package ruslan.reminnyi.metodlgd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ruslan Reminnyi
 * @version 1.0
 */
public class TheoryActivity extends AppCompatActivity implements View.OnClickListener {
    /* The activity shows pdf-file with theory */

    private ImageView imageViewPdf;
    private FloatingActionButton prePageButton;
    private FloatingActionButton nextPageButton;

    private PdfRenderer pdfRenderer;
    private PdfRenderer.Page currentPage;
    private ParcelFileDescriptor parcelFileDescriptor;

    private static final String FILENAME = "theory.pdf";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageViewPdf = (ImageView) findViewById(R.id.pdf_image);
        prePageButton = (FloatingActionButton) findViewById(R.id.previous_page_button);
        nextPageButton = (FloatingActionButton) findViewById(R.id.next_page_button);
        prePageButton.setOnClickListener(this);
        nextPageButton.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onStart() {
        super.onStart();

        try {
            openRenderer(this);    // initialization renderer
            showPage(0);    // at the beginning the first page will open
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onStop() {
        // cleaning the resources

        try {
            if (currentPage != null) {
                currentPage.close();
            }
            pdfRenderer.close();
            parcelFileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previous_page_button:
                showPage(currentPage.getIndex() - 1);
                break;
            case R.id.next_page_button:
                showPage(currentPage.getIndex() + 1);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void openRenderer(Context context) throws IOException {
        File file = new File(context.getCacheDir(), FILENAME);
        if (!file.exists()) {
            InputStream asset = context.getAssets().open(FILENAME);
            FileOutputStream output = new FileOutputStream(file);
            final byte[] buffer = new byte[1024];
            int size;
            while ((size = asset.read(buffer)) != -1) {
                output.write(buffer, 0, size);
            }
            asset.close();
            output.close();
        }

        parcelFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
        if (parcelFileDescriptor != null) {
            pdfRenderer = new PdfRenderer(parcelFileDescriptor);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showPage(int index) {

        if (pdfRenderer.getPageCount() <= index) {
            return;
        }

        if (currentPage != null) {
            currentPage.close();
        }

        currentPage = pdfRenderer.openPage(index);

        Bitmap bitmap = Bitmap.createBitmap(currentPage.getWidth(), currentPage.getHeight(),
                Bitmap.Config.ARGB_8888);

        currentPage.render(bitmap, null, null
                , PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

        imageViewPdf.setImageBitmap(bitmap);

        updateUi();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateUi() {
        // updates the state of 2 control buttons in response to the current page index

        prePageButton.setEnabled(currentPage.getIndex() > 0);
        nextPageButton.setEnabled(currentPage.getIndex() + 1 < pdfRenderer.getPageCount());
    }

}

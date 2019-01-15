package ruslan.reminnyi.metodlgd;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterValueDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.v("DialogFragment", "Create");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.enter_value_dialog, null))
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_button_ok, this)
                .setNegativeButton(R.string.dialog_button_cancel, this);


        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        switch (i) {
            case Dialog.BUTTON_POSITIVE:
                enterValueOfCell();
                break;
            case Dialog.BUTTON_NEGATIVE:
                Log.v("DialogFragment", "Button cancel");
                EnterValueDialog.this.getDialog().cancel();
                break;
        }

    }

    public void enterValueOfCell() {

        EditText editTextDialog = (EditText) getDialog().findViewById(R.id.edit_text_dialog);

        if ((editTextDialog.getText().toString().isEmpty())) {
            Toast.makeText(getActivity(), "You didn't enter value", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            String value = editTextDialog.getText().toString();
            Double userValue = Double.parseDouble(value);
            checkValue(userValue);
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Enter numeric value", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Value is wrong", Toast.LENGTH_LONG).show();
        }

        mainActivity.onResume();

    }

    public void checkValue(Double userValue) throws ArrayIndexOutOfBoundsException, NumberFormatException {

        if (LGDApplication.getMatrix().get(LGDApplication.getPositionValue()).equals(userValue)) {
            LGDApplication.getUserList().set(LGDApplication.getPositionValue(), userValue);
        }
        else
            Toast.makeText(getActivity(), "Value is wrong", Toast.LENGTH_LONG).show();
    }

}

package com.example.stickynotes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout notesLayout;
    private EditText newNoteEditText;
    private Button addNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesLayout = findViewById(R.id.notes_layout);
        newNoteEditText = findViewById(R.id.new_note_edittext);
        addNoteButton = findViewById(R.id.add_note_button);

        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteText = newNoteEditText.getText().toString();
                if (!noteText.isEmpty()) {
                    createNoteTextView(noteText);
                    newNoteEditText.setText("");
                }
            }
        });
    }

    private void createNoteTextView(String text) {
        TextView noteTextView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 0, 16);
        noteTextView.setLayoutParams(params);
        noteTextView.setText(text);
        noteTextView.setBackgroundColor(getResources().getColor(R.color.note_background));
        noteTextView.setTextColor(getResources().getColor(R.color.note_text_color));
        notesLayout.addView(noteTextView);
    }
}

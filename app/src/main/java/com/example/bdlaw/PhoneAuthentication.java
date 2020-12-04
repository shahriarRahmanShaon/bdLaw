package com.example.bdlaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneAuthentication extends AppCompatActivity
{
    private EditText phoneNumber;
    private Button button;
    private static final String TAG = "PhoneAuthentication";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_authentication);

        phoneNumber = (EditText)findViewById(R.id.input);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String phoneNo = phoneNumber.getText().toString();
                if (phoneNo.isEmpty())
                {
                    Toast.makeText(PhoneAuthentication.this,"Enter your phone number",Toast.LENGTH_LONG).show();
                }
                else
                {
                    PhoneAuthProvider.getInstance().verifyPhoneNumber("+880"+phoneNumber, 60, TimeUnit.SECONDS, PhoneAuthentication.this,
                            //------------------------------------------
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        signInUser(phoneAuthCredential);
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    Log.d(TAG, "verification failed" + e.getLocalizedMessage());
                                }

                                @Override
                                public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    super.onCodeSent(verificationId, forceResendingToken);
                                    Dialog dialog = new Dialog(PhoneAuthentication.this);
                                    dialog.setContentView(R.layout.verify_popup);
                                    EditText otpVerifyCode = dialog.findViewById(R.id.otpTextView);
                                    Button otpVerifyButton = dialog.findViewById(R.id.otpButton);
                                    otpVerifyButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String verificationCode = otpVerifyCode.getText().toString();
                                            if (verificationCode.isEmpty()) return;
                                            //create credential
                                            PhoneAuthCredential credential= PhoneAuthProvider.getCredential(verificationId,verificationCode);
                                            signInUser(credential);
                                        }
                                    });
                                    dialog.show();
                                }
                            });
                }
            }

        });


    }
    private void signInUser(PhoneAuthCredential credential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(PhoneAuthentication.this,LawerConnection.class));
                        }else {
                            //
                        }
                    }
                });

    }
}
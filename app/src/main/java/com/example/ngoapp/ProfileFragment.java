package com.example.ngoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProfileFragment extends Fragment {

    TextView name;
    TextView username;
    TextView email;
    TextView phone;

    Button login;
    Button signup;

    Button logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        name = view.findViewById(R.id.profile_text_name);
        username = view.findViewById(R.id.profile_text_username);
        email = view.findViewById(R.id.profile_text_email);
        phone = view.findViewById(R.id.profile_text_phone);

        login = view.findViewById(R.id.profile_button_login);
        signup = view.findViewById(R.id.profile_button_signup);

        logout = view.findViewById(R.id.profile_button_logout);

        login.setVisibility(View.INVISIBLE);
        signup.setVisibility(View.INVISIBLE);

        try {
            File file = new File(getActivity().getFilesDir(), "abc.txt");

            FileReader fd = new FileReader(file);
            Scanner scan = new Scanner(fd);

            String str = scan.nextLine();

            if (str.equals("nil")) {
                view.findViewById(R.id.profile_label_name).setVisibility(View.INVISIBLE);
                view.findViewById(R.id.profile_label_username).setVisibility(View.INVISIBLE);
                view.findViewById(R.id.profile_label_email).setVisibility(View.INVISIBLE);
                view.findViewById(R.id.profile_label_phone).setVisibility(View.INVISIBLE);

                name.setVisibility(View.INVISIBLE);
                username.setVisibility(View.INVISIBLE);
                email.setVisibility(View.INVISIBLE);
                phone.setVisibility(View.INVISIBLE);

                login.setVisibility(View.VISIBLE);
                signup.setVisibility(View.VISIBLE);

                logout.setVisibility(View.INVISIBLE);
            }
            else {
                name.setText(str);

                str = scan.nextLine();
                username.setText(str);

                str = scan.nextLine();
                email.setText(str);

                str = scan.nextLine();
                phone.setText(str);
            }

            fd.close();
        }
        catch (Exception e) {
            Toast.makeText(getContext(), "Excpetion: " + e, Toast.LENGTH_SHORT).show();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File file = new File(getActivity().getFilesDir(), "abc.txt");

                    FileWriter fw = new FileWriter(file);

                    fw.write("John Carter\n");
                    fw.write("john_carter123\n");
                    fw.write("johncr123@ngoapp.com\n");
                    fw.write("0000000000\n");

                    fw.close();
                }
                catch (Exception e) {
                    Toast.makeText(getContext(), "Excpetion: " + e, Toast.LENGTH_SHORT).show();
                }

                startActivity(new Intent(getActivity(), Login.class));
                getActivity().finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File file = new File(getActivity().getFilesDir(), "abc.txt");

                    FileWriter fw = new FileWriter(file);

                    fw.write("John Carter\n");
                    fw.write("john_carter123\n");
                    fw.write("cjohn123@ngoapp.com\n");
                    fw.write("0000000000\n");

                    fw.close();
                }
                catch (Exception e) {
                    Toast.makeText(getContext(), "Excpetion: " + e, Toast.LENGTH_SHORT).show();
                }

                startActivity(new Intent(getActivity(), Signup.class));
                getActivity().finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File file = new File(getActivity().getFilesDir(), "abc.txt");

                    PrintWriter pw = new PrintWriter(file);
                    pw.write("nil\n");
                    pw.close();
                }
                catch (Exception e) {
                    Toast.makeText(getContext(), "Excpetion: " + e, Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(getContext(), "Successfully logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }
        });

        return view;
    }
}

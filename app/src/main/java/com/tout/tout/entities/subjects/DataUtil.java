package com.tout.tout.entities.subjects;

import com.tout.tout.App;
import com.tout.tout.R;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<Subject> generateSubjects() {

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(App.getContext().getResources().getString(R.string.wikipedia),
                App.getContext().getResources().getString(R.string.wikipedia_description)));
        subjects.add(new Subject(App.getContext().getResources().getString(R.string.ox_dict),
                App.getContext().getResources().getString(R.string.ox_dict_description)));
        subjects.add(new Subject(App.getContext().getResources().getString(R.string.urban_dict),
                App.getContext().getResources().getString(R.string.urban_dict_description)));
        subjects.add(new Subject(App.getContext().getResources().getString(R.string.languages),
                App.getContext().getResources().getString(R.string.languages_description)));
        subjects.add(new Subject(App.getContext().getResources().getString(R.string.lexigram),
                App.getContext().getResources().getString(R.string.lexigram_description)));
        return subjects;
    }
}
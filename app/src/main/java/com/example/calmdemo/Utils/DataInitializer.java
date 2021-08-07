package com.example.calmdemo.Utils;

import com.example.calmdemo.R;
import com.example.calmdemo.Model.Exercise;

import java.util.List;


public class DataInitializer {

    public static void initData(List<Exercise> exerciseList) {
        exerciseList.add(new Exercise(R.drawable.easy_pose, "Easy Pose"));
        exerciseList.add(new Exercise(R.drawable.cobra_pose, "Cobra Pose"));
        exerciseList.add(new Exercise(R.drawable.downward_facing_dog, "Downward Facing Dog"));
        exerciseList.add(new Exercise(R.drawable.boat_pose, "Boat Pose"));
        exerciseList.add(new Exercise(R.drawable.half_pigeon, "Half Pigeon"));
        exerciseList.add(new Exercise(R.drawable.low_lunge, "Low Lunge"));
        exerciseList.add(new Exercise(R.drawable.upward_bow, "Upward Bow"));
        exerciseList.add(new Exercise(R.drawable.crescent_lunge, "Crescent Lunge"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose, "Warrior Pose I"));
        exerciseList.add(new Exercise(R.drawable.bow_pose, "Bow Pose"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose_2, "Warrior Pose II"));
    }
}

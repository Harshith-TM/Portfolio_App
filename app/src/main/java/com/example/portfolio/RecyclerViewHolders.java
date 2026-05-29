package com.example.portfolio;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolders {
    static TextCustomization textCustomization = new TextCustomization();
    static Animation fade_1000, fade_1500, fade_2000;

    static class HeroViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        Button know_more;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title1);
            know_more = itemView.findViewById(R.id.explore);
        }

        void bind() {
            textCustomization.TitleTextColor(title);
            know_more.setOnClickListener(view -> {
                RecyclerScroller recyclerScroller = new RecyclerScroller(itemView.getContext());
                RecyclerView recyclerView = (RecyclerView) itemView.getParent();
                recyclerScroller.smoothScrollTo(2, recyclerView);
            });
        }
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView labelHome, about, highlight1, highlight2, highlight3;
        ImageView profile;
        CardView card_view;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            labelHome = itemView.findViewById(R.id.label_about_me);
            about = itemView.findViewById(R.id.about);
            highlight1 = itemView.findViewById(R.id.highlight1);
            highlight2 = itemView.findViewById(R.id.highlight2);
            highlight3 = itemView.findViewById(R.id.highlight3);
            profile = itemView.findViewById(R.id.profile_icon);
            card_view = itemView.findViewById(R.id.card_view);
        }

        void bind() {
            textCustomization.LabelUnderLine(labelHome);
            textCustomization.HighlightsTextColor(highlight1);
            textCustomization.HighlightsTextColor(highlight2);
            textCustomization.HighlightsTextColor(highlight3);
        }

        void onAttached() {
            fade_1000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1000.setStartOffset(1000);
            fade_1500 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1500.setStartOffset(1500);
            fade_2000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_2000.setStartOffset(2000);
            labelHome.startAnimation(fade_1000);
            profile.startAnimation(fade_1000);
            about.startAnimation(fade_1500);
            highlight1.startAnimation(fade_1500);
            highlight2.startAnimation(fade_1500);
            highlight3.startAnimation(fade_1500);
            card_view.startAnimation(fade_2000);
        }

        void onDetached() {
            labelHome.clearAnimation();
            about.clearAnimation();
            highlight1.clearAnimation();
            highlight2.clearAnimation();
            highlight3.clearAnimation();
            profile.clearAnimation();
            card_view.clearAnimation();
        }
    }

    static class ProjectsViewHolder extends RecyclerView.ViewHolder {
        TextView labelProjects;
        CardView projectCard1, projectCard2, projectCard3;
        Button project1Info, project2Info, project3Info;

        public ProjectsViewHolder(@NonNull View itemView) {
            super(itemView);
            labelProjects = itemView.findViewById(R.id.label_projects);
            projectCard1 = itemView.findViewById(R.id.project_card1);
            projectCard2 = itemView.findViewById(R.id.project_card2);
            projectCard3 = itemView.findViewById(R.id.project_card3);
            project1Info = itemView.findViewById(R.id.know_more1);
            project2Info = itemView.findViewById(R.id.know_more2);
            project3Info = itemView.findViewById(R.id.know_more3);
        }

        void bind(Context context) {
            Intent intent = new Intent(context, ActivityProjectInfo.class);
            textCustomization.LabelUnderLine(labelProjects);
            project1Info.setOnClickListener(v -> {
                intent.putExtra("ProjectId", 1);
                context.startActivity(intent);
            });
            project2Info.setOnClickListener(v -> {
                intent.putExtra("ProjectId", 2);
                context.startActivity(intent);
            });
            project3Info.setOnClickListener(v -> {
                intent.putExtra("ProjectId", 3);
                context.startActivity(intent);
            });
        }

        void onAttached() {
            fade_1000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1000.setStartOffset(1000);
            fade_1500 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1500.setStartOffset(1500);
            fade_2000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_2000.setStartOffset(2000);
            labelProjects.startAnimation(fade_1000);
            projectCard1.startAnimation(fade_1000);
            projectCard2.startAnimation(fade_1500);
            projectCard3.startAnimation(fade_2000);
        }

        void onDetached() {
            labelProjects.clearAnimation();
            projectCard1.clearAnimation();
            projectCard2.clearAnimation();
            projectCard3.clearAnimation();
        }
    }

    static class SkillsViewHolder extends RecyclerView.ViewHolder {
        TextView labelSkills, mySkills, toolsAndTech, additional;
        ConstraintLayout skillsContainer, additionalContainer;

        public SkillsViewHolder(@NonNull View itemView) {
            super(itemView);
            labelSkills = itemView.findViewById(R.id.label_skills);
            mySkills = itemView.findViewById(R.id.my_skills);
            toolsAndTech = itemView.findViewById(R.id.tools_n_tech);
            additional = itemView.findViewById(R.id.additional);
            skillsContainer = itemView.findViewById(R.id.skills_container);
            additionalContainer = itemView.findViewById(R.id.additional_container);
        }

        void bind() {
            textCustomization.LabelUnderLine(labelSkills);
        }

        void onAttached() {
            fade_1000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1000.setStartOffset(1000);
            fade_1500 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1500.setStartOffset(1500);
            fade_2000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_2000.setStartOffset(2000);
            labelSkills.startAnimation(fade_1000);
            mySkills.startAnimation(fade_1000);
            toolsAndTech.startAnimation(fade_1500);
            skillsContainer.startAnimation(fade_1500);
            additional.startAnimation(fade_2000);
            additionalContainer.startAnimation(fade_2000);
        }

        void onDetached() {
            labelSkills.clearAnimation();
            mySkills.clearAnimation();
            toolsAndTech.clearAnimation();
            skillsContainer.clearAnimation();
            additional.clearAnimation();
            additionalContainer.clearAnimation();
        }
    }

    static class ExperienceViewHolder extends RecyclerView.ViewHolder {
        TextView labelExperience, expLevel, overview;
        ImageView iconExperience;
        View divider;
        LinearLayout workContainer;

        public ExperienceViewHolder(@NonNull View itemView) {
            super(itemView);
            labelExperience = itemView.findViewById(R.id.label_experience);
            iconExperience = itemView.findViewById(R.id.icon_experience);
            expLevel = itemView.findViewById(R.id.exp_level);
            overview = itemView.findViewById(R.id.overview);
            divider = itemView.findViewById(R.id.divider);
            workContainer = itemView.findViewById(R.id.work_container);
        }

        void bind() {
            textCustomization.LabelUnderLine(labelExperience);
        }

        void onAttached() {
            fade_1000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1000.setStartOffset(1000);
            fade_1500 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1500.setStartOffset(1500);
            fade_2000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_2000.setStartOffset(2000);
            labelExperience.startAnimation(fade_1000);
            iconExperience.startAnimation(fade_1000);
            expLevel.startAnimation(fade_1500);
            overview.startAnimation(fade_1500);
            divider.startAnimation(fade_2000);
            workContainer.startAnimation(fade_2000);
        }

        void onDetached() {
            labelExperience.clearAnimation();
            iconExperience.clearAnimation();
            expLevel.clearAnimation();
            overview.clearAnimation();
            divider.clearAnimation();
            workContainer.clearAnimation();
        }
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView labelGetInTouch, contact_subtitle;
        CardView contact_email, contact_phone, location, contact_github, contact_linkedin;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            labelGetInTouch = itemView.findViewById(R.id.label_get_in_touch);
            contact_subtitle = itemView.findViewById(R.id.contact_subtitle);
            contact_email = itemView.findViewById(R.id.contact_email);
            contact_phone = itemView.findViewById(R.id.contact_phone);
            location = itemView.findViewById(R.id.contact_location);
            contact_github = itemView.findViewById(R.id.contact_github);
            contact_linkedin = itemView.findViewById(R.id.contact_linkedin);
        }

        void bind(Context context) {
            textCustomization.LabelUnderLine(labelGetInTouch);
            contact_email.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail-id@gmail.com"});
                context.startActivity(Intent.createChooser(intent, "Send Email"));
            });
            contact_phone.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0123456789"));
                context.startActivity(intent);
            });
            location.setOnClickListener(v -> {
                double latitude = 12.987977;
                double longitude = 77.6219718;
                Uri locationUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);
                context.startActivity(intent);
            });
            contact_github.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.github.com/Harshith-TM"));
                context.startActivity(intent);
            });
            contact_linkedin.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/in/Harshith-TM"));
                context.startActivity(intent);
            });
        }

        void onAttached() {
            fade_1000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1000.setStartOffset(1000);
            fade_1500 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_1500.setStartOffset(1500);
            fade_2000 = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade);
            fade_2000.setStartOffset(2000);
            labelGetInTouch.startAnimation(fade_1000);
            contact_subtitle.startAnimation(fade_1000);
            contact_email.startAnimation(fade_1500);
            contact_phone.startAnimation(fade_1500);
            location.startAnimation(fade_2000);
            contact_github.startAnimation(fade_2000);
            contact_linkedin.startAnimation(fade_2000);
        }

        void onDetached() {
            labelGetInTouch.clearAnimation();
            contact_subtitle.clearAnimation();
            contact_email.clearAnimation();
            contact_phone.clearAnimation();
            location.clearAnimation();
            contact_github.clearAnimation();
            contact_linkedin.clearAnimation();
        }
    }
}
package com.example.portfolio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.RecyclerViewHolders.ContactViewHolder;
import com.example.portfolio.RecyclerViewHolders.ExperienceViewHolder;
import com.example.portfolio.RecyclerViewHolders.HeroViewHolder;
import com.example.portfolio.RecyclerViewHolders.HomeViewHolder;
import com.example.portfolio.RecyclerViewHolders.ProjectsViewHolder;
import com.example.portfolio.RecyclerViewHolders.SkillsViewHolder;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    public static final int View_Hero = 0;
    public static final int View_Home = 1;
    public static final int View_Skill = 3;
    public static final int View_Project = 2;
    public static final int View_Experience = 4;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == View_Hero) {
            View view = inflater.inflate(R.layout.section_hero, parent, false);
            return new HeroViewHolder(view);
        } else if (viewType == View_Home) {
            View view = inflater.inflate(R.layout.section_home, parent, false);
            return new HomeViewHolder(view);
        } else if (viewType == View_Project) {
            View view = inflater.inflate(R.layout.section_projects, parent, false);
            return new ProjectsViewHolder(view);
        } else if (viewType == View_Skill) {
            View view = inflater.inflate(R.layout.section_skills, parent, false);
            return new SkillsViewHolder(view);
        } else if (viewType == View_Experience) {
            View view = inflater.inflate(R.layout.section_experience, parent, false);
            return new ExperienceViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.section_contact, parent, false);
            return new ContactViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeroViewHolder) {
            ((HeroViewHolder) holder).bind();
        } else if (holder instanceof HomeViewHolder) {
            ((HomeViewHolder) holder).bind();
        } else if (holder instanceof ProjectsViewHolder) {
            ((ProjectsViewHolder) holder).bind(context);
        } else if (holder instanceof SkillsViewHolder) {
            ((SkillsViewHolder) holder).bind();
        } else if (holder instanceof ExperienceViewHolder) {
            ((ExperienceViewHolder) holder).bind();
        } else if (holder instanceof ContactViewHolder) {
            ((ContactViewHolder) holder).bind(context);
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder instanceof HeroViewHolder) {
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.fade);
            holder.itemView.startAnimation(animation);
        } else if (holder instanceof HomeViewHolder) {
            ((HomeViewHolder) holder).onAttached();
        } else if (holder instanceof ProjectsViewHolder) {
            ((ProjectsViewHolder) holder).onAttached();
        } else if (holder instanceof SkillsViewHolder) {
            ((SkillsViewHolder) holder).onAttached();
        } else if (holder instanceof ExperienceViewHolder) {
            ((ExperienceViewHolder) holder).onAttached();
        } else if (holder instanceof ContactViewHolder) {
            ((ContactViewHolder) holder).onAttached();
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
        if (holder instanceof HomeViewHolder) {
            ((HomeViewHolder) holder).onDetached();
        } else if (holder instanceof ProjectsViewHolder) {
            ((ProjectsViewHolder) holder).onDetached();
        }else if (holder instanceof SkillsViewHolder) {
            ((SkillsViewHolder) holder).onDetached();
        }else if (holder instanceof ExperienceViewHolder) {
            ((ExperienceViewHolder) holder).onDetached();
        } else if (holder instanceof ContactViewHolder) {
            ((ContactViewHolder) holder).onDetached();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
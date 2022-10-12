package cl.uandes.taskapp.ui.HomeProjects

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.taskapp.R
import cl.uandes.taskapp.data.model.Project

class ProjectItemAdapter(
  private val projects: MutableList<Project>,
  private val actionListener: ActionListener
) : RecyclerView.Adapter<ProjectItemAdapter.ViewHolder>() {

  inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val projectItem = itemView.findViewById<ViewGroup>(R.id.projectItem)
    val projectTitle = itemView.findViewById<TextView>(R.id.projectTitleTextView)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    val context = parent.context
    val inflater = LayoutInflater.from(context)
    val projectItemView: View = inflater.inflate(R.layout.home_project_item, parent, false)

    return ViewHolder(projectItemView)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val project: Project = projects[position]

    //Here goes only whatever args you wanna show in the recycler view
    val detailsButton = holder.projectItem
    val title = holder.projectTitle

    title.text = project.title

    detailsButton.setOnClickListener {
      actionListener.goToProjectDetails(project)
    }
  }
  override fun getItemCount(): Int {
    return projects.size
  }

  @SuppressLint("NotifyDataSetChanged")
  fun updateProjects(newProjectList: MutableList<Project>) {
    projects.clear()
    projects.addAll(newProjectList)

    notifyDataSetChanged()
  }

  interface ActionListener {
    fun goToProjectDetails(project: Project)
  }
}

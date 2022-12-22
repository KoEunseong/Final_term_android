package com.example.final_project

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class MainListAdapter (var study: ArrayList<Study>, var con: Context) : RecyclerView.Adapter<MainListAdapter.ViewHolder>(), Filterable {
    var TAG = "MainListAdapter"

    var filteredStudy = ArrayList<Study>()
    var itemFilter = ItemFilter()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var subjectName: TextView
        var contentOfStudy: TextView

        init {
            subjectName = itemView.findViewById(R.id.subjectName)
            contentOfStudy = itemView.findViewById(R.id.contentOfStudy)
            itemView.setOnClickListener {
                AlertDialog.Builder(con).apply {
                    var position = adapterPosition
                    var study = filteredStudy[position]
                    setTitle(study.subject)
                    setMessage(study.contentOfStudy)
                    setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(con, "OK Button Click", Toast.LENGTH_SHORT).show()
                    })
                    show()
                }
            }
        }
    }
    init {
        filteredStudy.addAll(study)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val con = parent.context
        val inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.studyitem, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val study: Study = filteredStudy[position]
        holder.subjectName.text = study.subject
        holder.contentOfStudy.text = study.contentOfStudy
    }

    override fun getItemCount(): Int {
        return filteredStudy.size
    }
    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<Study> = ArrayList<Study>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = study
                results.count = study.size

                return results
                //공백제외 2글자 이인 경우 -> 이름으로만 검색
            } else if (filterString.trim { it <= ' ' }.length <= 20) {
                for (s in study) {
                    if (s.subject.contains(filterString)) {
                        filteredList.add(s)
                    }
                }
                //그 외의 경우(공백제외 2글자 초과) -> 이름/전화번호로 검색
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        //처리에 대한 결과물
        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredStudy.clear()
            filteredStudy.addAll(filterResults.values as ArrayList<Study>)
            notifyDataSetChanged()
        }
    }

}

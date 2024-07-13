package grupo6.examen.practicas;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import grupo6.examen.practicas.model.Curso;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.CursoViewHolder> {

    private List<Curso> cursos = new ArrayList<>();

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_curso, parent, false);
        return new CursoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CursoViewHolder holder, int position) {
        Curso curso = cursos.get(position);
        holder.bind(curso);
    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }

    public static class CursoViewHolder extends RecyclerView.ViewHolder {

        private TextView nombreCurso;
        // private TextView descripcionCurso; // No se está usando actualmente

        public CursoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreCurso = itemView.findViewById(R.id.button_curso);
            // descripcionCurso = itemView.findViewById(R.id.descripcion_curso);
        }

        public void bind(Curso curso) {
            nombreCurso.setText(curso.getNombre());
            // Si tienes un TextView para la descripción del curso, descomenta esta línea
            // descripcionCurso.setText(curso.getDescripcion());
        }
    }
}
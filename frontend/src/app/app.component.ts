import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient, HttpParams  } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { StatusAtividade } from 'src/app/status-atividade.enum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  
  toDoForm: FormGroup;
  atividades:Array<Atividade>;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
    this.toDoForm = this.formBuilder.group({
      atividade: [null]
    });
    this.listAtividades();
  }

  add() {
    if(this.toDoForm.get('atividade').value != null) {
      const body = { descricao: this.toDoForm.get('atividade').value };
      this.http.put<Atividade>(environment.apiURL + '/atividade/adicionar', body)
        .subscribe(data => { 
          this.listAtividades();
        });
      this.toDoForm.reset();
    } else {
      alert('Informe uma atividade!');
    }
  }

  listAtividades() {
    this.http.get<any>(environment.apiURL + '/atividade/list')
      .subscribe(data => { 
        this.atividades = data 
      });
  }

  excluir(index: number) {
    const params = new HttpParams().set('id', this.atividades[index].id.toString());
    this.http.delete<any>(environment.apiURL + '/atividade/excluir', {params})
      .subscribe(data => {
        this.listAtividades();
      });
  }

  concluir(index: number) {
    const body = this.atividades[index].id 
    if(this.atividades[index].status == StatusAtividade.A_FAZER) {
      this.http.post<any>(environment.apiURL + '/atividade/feito', body)
        .subscribe();
    } else {
      this.http.post<any>(environment.apiURL + '/atividade/fazer', body)
      .subscribe();
    }
  }
}

interface Atividade {
  id: number;
  descricao: string;
  status: StatusAtividade;
  data: Date;
}

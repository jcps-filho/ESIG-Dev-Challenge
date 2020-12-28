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
  atividadesPorFazer = [];
  atividadesFeitas = [];
  checked = false;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
    this.toDoForm = this.formBuilder.group({
      atividade: [null]
    });
    this.listAtividadesPorFazer();
    this.listAtividadesFeitas();
  }

  add() {
    if(this.toDoForm.get('atividade').value != null) {
      const body = { descricao: this.toDoForm.get('atividade').value };
      this.http.put<Atividade>(environment.apiURL + '/atividade/adicionar', body)
        .subscribe(data => { 
          this.listAtividadesPorFazer();
          this.listAtividadesFeitas(); 
        });
      this.toDoForm.reset();
    } else {
      alert('Informe uma atividade!');
    }
  }

  listAtividadesPorFazer() {
    const params = new HttpParams().set('status', '0');
    this.http.get<any>(environment.apiURL + '/atividade/listByStatus', {params})
      .subscribe(data => { this.atividadesPorFazer = data });
  }

  listAtividadesFeitas() {
    const params = new HttpParams().set('status', '1');
    this.http.get<any>(environment.apiURL + '/atividade/listByStatus', {params})
      .subscribe(data => this.atividadesFeitas = data);
  }

  excluir() {
    const params = new HttpParams().set('id', '1');
    this.http.delete<any>(environment.apiURL + '/atividade/excluir', {params})
      .subscribe(data => console.log(data));
  }

  concluir(event: any) {
    console.log('Finalizar atividade');
    console.log(event);
  }
}

interface Atividade {
  id: number;
  descricao: string;
  status: StatusAtividade;
  data: Date;
}

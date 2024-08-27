import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = "http://localhost:8080";

@Injectable({
  providedIn: 'root'
})
export class DespesaService {
  constructor(private http: HttpClient) { }

  postDespesa(despesaDTO: any): Observable<any> {
    return this.http.post(`${BASIC_URL}/api/despesa`, despesaDTO);
  }

  getAllDespesas(): Observable<any> {
    return this.http.get(`${BASIC_URL}/api/despesa/all`);
  }

  deleteDespesa(id: number): Observable<any> {
    return this.http.delete(`${BASIC_URL}/api/despesa/${id}`);
  }

  getDespesaById(id: number): Observable<any> {
    return this.http.get(`${BASIC_URL}/api/despesa/${id}`);
  }

  atualizacaoDespesa(id: number, despesaDTO: any): Observable<any> {
    return this.http.put(`${BASIC_URL}/api/despesa/${id}`, despesaDTO);
  }
}

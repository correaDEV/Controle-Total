import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const BASIC_URL = "http://localhost:8080";

@Injectable({
  providedIn: 'root'
})
export class RendaService {
  constructor(private http: HttpClient) { }

  postRenda(rendaDTO: any): Observable<any> {
    return this.http.post(`${BASIC_URL}/api/renda`, rendaDTO);
  }

  getAllrendas(): Observable<any> {
    return this.http.get(`${BASIC_URL}/api/renda/all`);
  }

  getRendaById(id:number): Observable<any> {
    return this.http.get(`${BASIC_URL}/api/renda/${id}`);
  }

  atualizarRenda(id:number, rendaDTO:any): Observable<any> {
    return this.http.put(`${BASIC_URL}/api/renda/${id}` , rendaDTO);
  }

  deleteRenda(id:number): Observable<any> {
    return this.http.delete(`${BASIC_URL}/api/renda/${id}`);
  }
}

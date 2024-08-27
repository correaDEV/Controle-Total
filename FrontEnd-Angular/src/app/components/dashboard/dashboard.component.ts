import { Component, ElementRef, ViewChild } from '@angular/core';
import { StatsService } from 'src/app/services/stats/stats.service';
import Chart from 'chart.js/auto';
import { CategoryScale } from 'chart.js/auto';

Chart.register(CategoryScale);

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  stats: any;
  despesas: any;
  rendas: any;

  gridStyle = {
    width: '25%',
    textAlign: 'center'
  };

  @ViewChild('rendaLineChartRef') private rendaLineChartRef:ElementRef;
  @ViewChild('despesaLineChartRef') private despesaLineChartRef:ElementRef;

  constructor(private statsService: StatsService) { 
    this.getStats();
    this.getChartData();
  }

  createLineChart(){
    const rendaCtx = this.rendaLineChartRef.nativeElement.getContext('2d');

    new Chart(rendaCtx, {
      type: 'line',
      data: {
        labels: this.rendas.map(renda => renda.date),
        datasets: [{
          label: 'Renda',
          data: this.rendas.map(renda => renda.amount),
          borderWidth: 1,
          backgroundColor: [
            '#127f0b',    
            '#40a532',  
            '#56b845',  
            '#6dcb59',  
            'rgba(75, 192, 192, 0.2)',  
            'rgba(75, 192, 192, 0.1)',  
        ],
          borderColor: '#999999',
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });

    const despesaCtx = this.despesaLineChartRef.nativeElement.getContext('2d');

    new Chart(despesaCtx, {
      type: 'bar',
      data: {
        labels: this.despesas.map(renda => renda.date),
        datasets: [{
          label: 'Despesa',
          data: this.despesas.map(renda => renda.amount),
          borderWidth: 1,
          backgroundColor: [
            '#f62913',    
            '#fb5333',  
            '#ff7c53',  
            'rgba(255, 99, 132, 0.4)',   
            'rgba(255, 99, 132, 0.2)',  
            'rgba(255, 99, 132, 0.1)',  
        ],
                  borderColor: 'red',
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }

  getStats() {
    this.statsService.getStats().subscribe(res => {
      console.log(res);
      this.stats = res;
    });
  }

  getChartData(){
    this.statsService.getChart().subscribe(res=> {
      if(res.despesaList != null && res.rendaList !=null){
        this.despesas = res.despesaList;
        this.rendas = res.rendaList;
        console.log(res);

        this.createLineChart();
        
      }
      
    })
  }

}

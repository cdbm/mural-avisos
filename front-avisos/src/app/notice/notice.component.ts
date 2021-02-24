import { Component, OnInit } from '@angular/core';
import { NoticeService } from "./notice.service";
import {Notice} from "./notice";

@Component({
  selector: 'app-notice',
  templateUrl: './notice.component.html',
  styleUrls: ['./notice.component.css']
})
export class NoticeComponent implements OnInit {
  notices: Notice[];

  constructor(private service : NoticeService) { }

  ngOnInit(): void {
    this.getNotices();
  }

  getNotices(): void {
    this.service.getNotices().toPromise().then((res:Notice[]) => {
      console.log(res)
      this.notices = res
    });
  }

}

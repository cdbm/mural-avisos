import {Component, Inject, OnInit} from '@angular/core';
import { NoticeService } from "./notice.service";
import {Notice} from "./notice";
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-notice',
  templateUrl: './notice.component.html',
  styleUrls: ['./notice.component.css']
})
export class NoticeComponent implements OnInit {
  notices: Notice[];
  last: Boolean;
  pages: number;
  clicked: Boolean;
  noticeTitle: string;
  noticeSub: string;

  constructor(private service : NoticeService, public dialog : MatDialog) { }

  ngOnInit(): void {
    this.getNotices();
    this.clicked = false;
  }


  getNotices(): void {
    this.service.getNotices().toPromise().then((res:any) => {
      this.notices = res.content;
      this.last = res.last;
      this.pages = res.totalPages;
      this.checkSeen();
    });
  }

  checkSeen(): void {
    for(var notice of this.notices){
      notice.seen = notice.seenAt == "" ? false : true;
    }
  }


  updateRead(notice: Notice): void {
      delete notice.seen;
      notice.seenAt = (new Date()).toDateString();
      this.service.update(notice);
  }

  deleteNotice(noticeId : number){
    this.notices = this.notices.filter(elem => elem.id != noticeId);
    this.service.deleteNotice(noticeId);
  }

  updateClick(){
    this.clicked = !this.clicked;
  }

  updateTitle(value: string){
    this.noticeTitle = value;
  }
  updateSub(value: string){
    this.noticeSub = value;
  }

  createNotice(){
    var newNotice: Notice = new Notice(this.noticeTitle, this.noticeSub, (new Date()).toDateString(), "");
    this.service.createNotice(newNotice).then(res => {
      this.getNotices();
    })
    this.noticeTitle = "";
    this.noticeSub = "";
  }
}


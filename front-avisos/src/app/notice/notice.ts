export class Notice{
  id: number;
  title: string;
  description: string;
  createdAt: string;
  seenAt: string;
  seen: Boolean;

  constructor(title: string, description: string, createdAt: string, seenAt:string) {
    this.title = title;
    this.description = description;
    this.createdAt = createdAt;
    this.seenAt = seenAt;
    this.seen = false;
  }
}

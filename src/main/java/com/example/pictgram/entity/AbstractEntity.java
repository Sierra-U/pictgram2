package com.example.pictgram.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

/*
 * ??@MappedSuperclassとは
 * 継承するエンティティにマッピング情報が適用されるクラスを指定し
 * マップされたスーパークラスには、個別に定義されたテーブルはない
 */
@MappedSuperclass
@Data
public class AbstractEntity {
	@Column(name = "created_at") //カラム名"created_at"を作る…中身は、Date型のcreatedAtを用意した
	private Date createdAt;

	@Column(name = "updated_at") //カラム名"updated_at"を作る…中身は、Date型のupdatedAtを用意した
	private Date updatedAt;
	
	/*
	 * ??@PrePersistとは
	 * 対応するライフサイクルイベントのコールバックメソッドを指定
	 * エンティティクラス、マップされたスーパークラス、またはコールバックリスナークラスのメソッドに適用できます
	 */
	@PrePersist
	public void onPrePersist() {
		Date date = new Date();
		setCreatedAt(date);
		setUpdatedAt(date);
	}

	@PreUpdate
	public void onPreUpdate() {
		setUpdatedAt(new Date());
	}

}

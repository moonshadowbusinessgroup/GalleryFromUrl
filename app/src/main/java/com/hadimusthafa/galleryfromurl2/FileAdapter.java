package com.hadimusthafa.galleryfromurl2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hadimusthafa.galleryfromurl2.Activity.AudioViewActivity;
import com.hadimusthafa.galleryfromurl2.Activity.ImageViewActivity;
import com.hadimusthafa.galleryfromurl2.Activity.PdfViewActivity;
import com.hadimusthafa.galleryfromurl2.Activity.VideoViewActivity;

import java.util.ArrayList;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<FileModel> dataModelArrayList;
    private Context mContext;
    String JSONA;

    public FileAdapter(Context ctx, ArrayList<FileModel> dataModelArrayList, String JSONaa) {
        inflater = LayoutInflater.from(ctx);
        this.dataModelArrayList = dataModelArrayList;
        this.JSONA = JSONaa;
        mContext = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String File = dataModelArrayList.get(position).getFile();
        if (File.equals("image")) {
            holder.iv.setVisibility(View.VISIBLE);
            holder.videoL.setVisibility(View.GONE);
            holder.pdfL.setVisibility(View.GONE);
            holder.mp3L.setVisibility(View.GONE);
            holder.allL.setVisibility(View.GONE);
            Glide.with(mContext).load(dataModelArrayList.get(position).getUrl()).into(holder.iv);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String from_iv = "from_iv";
                    String a = dataModelArrayList.get(position).getUrl();
                    String b = dataModelArrayList.get(position).getName();
                    Intent intent = new Intent(mContext, ImageViewActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("image", a);
                    intent.putExtra("name", b);
                    intent.putExtra("cp", position + "");
                    intent.putExtra("dma", JSONA);
                    intent.putExtra("from_iv", from_iv);
                    mContext.startActivity(intent);
                }
            });
        }
        if (File.equals("video")) {
            holder.videoL.setVisibility(View.VISIBLE);
            holder.pdfL.setVisibility(View.GONE);
            holder.iv.setVisibility(View.GONE);
            holder.mp3L.setVisibility(View.GONE);
            holder.allL.setVisibility(View.GONE);
            holder.video_name.setText(dataModelArrayList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = dataModelArrayList.get(position).getUrl();
                    String b = dataModelArrayList.get(position).getName();
                    Intent intent = new Intent(mContext, VideoViewActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("video", a);
                    intent.putExtra("name", b);
                    mContext.startActivity(intent);
                }
            });
        }
        if (File.equals("pdf")) {
            holder.pdfL.setVisibility(View.VISIBLE);
            holder.videoL.setVisibility(View.GONE);
            holder.iv.setVisibility(View.GONE);
            holder.mp3L.setVisibility(View.GONE);
            holder.allL.setVisibility(View.GONE);
            holder.pdf_name.setText(dataModelArrayList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = dataModelArrayList.get(position).getUrl();
                    Intent intent = new Intent(mContext, PdfViewActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("pdf", a);
                    mContext.startActivity(intent);
                }
            });
        }
        if (File.equals("audio")) {
            holder.mp3L.setVisibility(View.VISIBLE);
            holder.pdfL.setVisibility(View.GONE);
            holder.videoL.setVisibility(View.GONE);
            holder.iv.setVisibility(View.GONE);
            holder.allL.setVisibility(View.GONE);
            holder.mp3_name.setText(dataModelArrayList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a = dataModelArrayList.get(position).getUrl();
                    String b = dataModelArrayList.get(position).getName();
                    Intent intent = new Intent(mContext, AudioViewActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("mp3", a);
                    intent.putExtra("name", b);
                    mContext.startActivity(intent);
                }
            });
        }
        if (File.equals("all")) {
            holder.allL.setVisibility(View.VISIBLE);
            holder.mp3L.setVisibility(View.GONE);
            holder.pdfL.setVisibility(View.GONE);
            holder.videoL.setVisibility(View.GONE);
            holder.iv.setVisibility(View.GONE);

            String Url = dataModelArrayList.get(position).getUrl();
            String extension = Url.substring(Url.lastIndexOf("."));
            if (Url.contains(".unsplash") || extension.equals(".png") || extension.equals(".PNG") || extension.equals(".jpg") || extension.equals(".JPG") || extension.equals(".JPEG") || extension.equals(".jpeg")) {
                Glide.with(mContext).load(R.drawable.png).into(holder.file_image);
            }
            if (extension.equals(".mp4") || extension.equals(".MP4")) {
                Glide.with(mContext).load(R.drawable.mp4).into(holder.file_image);
            }
            if (extension.equals(".mp3") || extension.equals(".MP3") || extension.equals(".ogg") || extension.equals(".OGG")) {
                Glide.with(mContext).load(R.drawable.mp3).into(holder.file_image);
            }
            if (extension.equals(".pdf") || extension.equals(".PDF")) {
                Glide.with(mContext).load(R.drawable.pdf).into(holder.file_image);
            }

            holder.file_name.setText(dataModelArrayList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Url.contains(".unsplash") || extension.equals(".png") || extension.equals(".PNG") || extension.equals(".jpg") || extension.equals(".JPG") || extension.equals(".JPEG") || extension.equals(".jpeg")) {
                        String a = dataModelArrayList.get(position).getUrl();
                        String b = dataModelArrayList.get(position).getName();
                        Intent intent = new Intent(mContext, ImageViewActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("image", a);
                        intent.putExtra("name", b);
                        intent.putExtra("cp", position + "");
                        intent.putExtra("dma", JSONA);
                        mContext.startActivity(intent);
                    }
                    if (extension.equals(".mp4") || extension.equals(".MP4")) {
                        String a = dataModelArrayList.get(position).getUrl();
                        String b = dataModelArrayList.get(position).getName();
                        Intent intent = new Intent(mContext, VideoViewActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("video", a);
                        intent.putExtra("name", b);
                        mContext.startActivity(intent);
                    }
                    if (extension.equals(".mp3") || extension.equals(".MP3") || extension.equals(".ogg") || extension.equals(".OGG")) {
                        String a = dataModelArrayList.get(position).getUrl();
                        String b = dataModelArrayList.get(position).getName();
                        Intent intent = new Intent(mContext, AudioViewActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("mp3", a);
                        intent.putExtra("name", b);
                        mContext.startActivity(intent);
                    }
                    if (extension.equals(".pdf") || extension.equals(".PDF")) {
                        String a = dataModelArrayList.get(position).getUrl();
                        Intent intent = new Intent(mContext, PdfViewActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("pdf", a);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv, file_image;
        LinearLayout videoL, pdfL, mp3L, allL;
        TextView video_name, pdf_name, mp3_name, file_name;

        public MyViewHolder(final View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            videoL = itemView.findViewById(R.id.videoL);
            pdfL = itemView.findViewById(R.id.pdfL);
            mp3L = itemView.findViewById(R.id.mp3L);
            allL = itemView.findViewById(R.id.allL);
            video_name = itemView.findViewById(R.id.video_name);
            pdf_name = itemView.findViewById(R.id.pdf_name);
            mp3_name = itemView.findViewById(R.id.mp3_name);
            file_image = itemView.findViewById(R.id.file_image);
            file_name = itemView.findViewById(R.id.file_name);
        }
    }
}
